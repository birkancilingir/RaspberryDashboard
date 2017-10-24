average=`grep 'cpu ' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage}'`
core0=`grep 'cpu0' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage}'`
core1=`grep 'cpu1' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage}'`
core2=`grep 'cpu2' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage}'`
core3=`grep 'cpu3' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage}'`
echo '{ "cpuAverage" :' $average ', "core1" :'  $core0 ', "core2" :' $core1  ', "core3" :' $core2 ', "core4" :' $core3 '}'