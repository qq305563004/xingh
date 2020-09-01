package com.tk.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

import com.tk.bean.Permission;
import com.tk.constant.RetCodeConstant;
import com.tk.exception.WebBusinessException;
import com.tk.mapper.PermissionMapper;
import com.tk.security.dto.LoginCredentialsDto;
import com.tk.service.TokenCacheService;
import com.tk.utils.ApplicationUtil;
import com.tk.utils.MsgUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationService.class);

	/** JWT 过期时间：5天 */
	protected static final long EXPIRATIONTIME = 432_000_000;

	/** JWT密码 */
	protected static final String SECRET = "P@Kotei$88";

	/** Token前缀 */
	protected static final String TOKEN_PREFIX = "Bearer";

	/** 存放Token的Header Key */
	protected static final String HEADER_STRING = "Authorization";

	/** Login 超时时间：30分钟 */
	protected static final long LOGIN_TIMEOUT = 1800000;

	private TokenAuthenticationService() {
		super();
	}

	/**
	 * JWT生成
	 *
	 * @param userName 用户名
	 * @param userType 用户类型
	 * @param salt     Token盐值
	 * @return
	 */
	protected static String addAuthentication(String userName, String salt) {
		logger.info("TokenAuthenticationService:addAuthentication()");
		// 生成JWT
		return Jwts.builder()
				// Token盐值
				.claim("salt", salt)
				// 用户名写入标题
				.setSubject(userName)
				// 有效期设置
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				// 签名设置
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}

	/**
	 * * Token检测
	 *
	 * @param userName 用户名
	 * @param userType 用户类型
	 * @param salt     Token盐值
	 * @return
	 */
	private static LoginCredentialsDto checkToken(String userName, String salt) {

		TokenCacheService tokenCacheService = (TokenCacheService) ApplicationUtil.getBean("tokenCacheService");
		// 获取登录凭证
		LoginCredentialsDto loginCredentials = tokenCacheService.getLoginCredentials(userName);

		if (!salt.equals(loginCredentials.getSalt())) {
			// 账户已在其它地方登录
			logger.info(MsgUtils.retLog(RetCodeConstant.LOGIN_IN_ELSEWHERE));
			throw new WebBusinessException(RetCodeConstant.LOGIN_IN_ELSEWHERE);
		}
		if (loginCredentials.getLoginTime() < System.currentTimeMillis()) {
			// 登录超时
			logger.info(MsgUtils.retLog(RetCodeConstant.LOGIN_TIMEOUT));
			throw new WebBusinessException(RetCodeConstant.LOGIN_TIMEOUT);
		}
		loginCredentials.setLoginTime(System.currentTimeMillis() + LOGIN_TIMEOUT);
		tokenCacheService.cacheLoginCredentials(userName, loginCredentials);
		logger.info("TokenAuthenticationService:checkToken() SUCCESS");
		return loginCredentials;
	}

	/**
	 * JWT验证
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
//    protected static Authentication getAuthentication(HttpServletRequest request) {
//        logger.info("TokenAuthenticationService:getAuthentication() URL:" + request.getRequestURI());
//
//        if ("/login".equals(request.getRequestURI())) {
//            return new UsernamePasswordAuthenticationToken("systemDefault", null, null);
//        }
//
//        // 从Header中拿到token
//        String token = request.getHeader(HEADER_STRING);
//        if (token == null) {
//            return null;
//        }
//
//        // 解析 Token
//        Claims claims = Jwts.parser()
//                // 验签
//                .setSigningKey(SECRET)
//                // 去掉 Bearer
//                .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
//
//        // 获取用户名
//        String userName = claims.getSubject();
//        String salt = (String) claims.get("salt");
//        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(salt)) {
//            return null;
//        }
//
//        LoginCredentialsDto loginCredentials = checkToken(userName, salt);
//
//        // 获得权限
//        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(loginCredentials.getAuthorities());
//
//        return new UsernamePasswordAuthenticationToken(userName, null, authorities);
//    }

	/**
	 * 无需JWT验证(测试专用)
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	protected static Authentication getAuthentication(HttpServletRequest request) {
		String user = "admin";
		PermissionMapper permissionDao = (PermissionMapper) ApplicationUtil.getBean("permissionMapper");
		List<Permission> permissionList = permissionDao.selectAll();
		StringBuilder sb = new StringBuilder();
		for (Permission authority : permissionList) {
			sb.append(authority.getMark()).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(sb.toString());
		return new UsernamePasswordAuthenticationToken(user, null, authorities);
	}
}
