temperature=`cat /sys/class/thermal/thermal_zone0/temp`
echo '{ "temperature" :' $temperature '}'