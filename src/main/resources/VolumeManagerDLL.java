package src.main.resources;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VolumeManagerDLL extends Library
{
    VolumeManagerDLL INSTANCE = (VolumeManagerDLL) Native.loadLibrary("src/main/resources/VolumeManagerDLL.dll", VolumeManagerDLL.class);


    boolean _Z12ChangeVolumefbPKc(float deltaVolume, boolean add,  String programId);


}
