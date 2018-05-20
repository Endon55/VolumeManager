g++ -c -m64 VolumeManagerDLL.cpp
g++ -shared -m64 -o VolumeManagerDLL.dll VolumeManagerDLL.o -lOle32