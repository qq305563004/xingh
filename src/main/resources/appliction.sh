#!/bin/sh

start(){
tpid=`ps aux | grep -c 'xingh_jenkins2.jar'`

if [ $tpid -le 1 ]; then
	java -Xms512m -Xmx512m -jar xingh_jenkins2.jar  > console.log &
        echo $! > pid.log
else
        echo "alread start. PID:`cat pid.log`"
        exit 0
fi
}

stop(){
pid=`cat pid.log`
echo "Kill pid:$pid"
kill -9 $pid
rm pid.log
}


case "$1" in
        start)
                start
        ;;
        stop)
                stop
        ;;
        restart)
                stop
                start
        ;;
        *)
        ;;
esac

