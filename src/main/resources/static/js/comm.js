/**
 * 格式化权限数提交数据
 * @param data
 * @returns {*}
 */
function treeDataSubFormat(data, resData) {
  let subData = [];
  if (!data) return ''
  data.map(item => {
    if (subData.indexOf(item.id) == -1) {
      subData.push(item.id);
    }
    if (item.parentId && subData.indexOf(item.parentId) == -1) {
      subData.push(item.parentId);
      getParentId(resData, item.parentId, subData);
    }
  })
  return subData;
}

/**
 * 格式化树形结构数据
 * @param data
 * @returns {*}
 */
function treeDataFormat(data) {
  if (!data) return ''
  data.map(item => {
    if (item.level === 1) {
      item.expand = true;
    }
    if (item.children && item.selected) {
      treeDataFormat(item.children)
    } else {
      item.checked = item.selected === false ? false : true;
    }
  })
  return data;
}

/**
 * 隐藏姓名 手机号 身份证 银行卡 等中间字符信息
 * @param str
 * @returns {*}
 */
function star(value) {
  let str = value.toString()
  if (str.length > 0 && str.length < 3) {
    return '*' + str.substring(1)
  } else if (str.length > 5 && str.length < 12) {
    return str.substr(0, 3) + '****' + str.substr(-4)
  } else if (str.length > 14) {
    return str.substr(0, 4) + '***********' + str.substr(-4)
  } else {
    return str
  }
}

function getParentId(data, id, arr) {
  data.map(item => {
    if (item.id === id) {
      if (item.parentId && arr.indexOf(item.parentId) == -1) {
        arr.push(item.parentId);
        // getParentId(data,item.parentId,arr);
      }
    } else if (item.children) {
      getParentId(item.children, id, arr);
    }
  })
}