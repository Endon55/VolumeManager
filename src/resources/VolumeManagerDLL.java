package resources;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VolumeManagerDLL extends Library
{
    VolumeManagerDLL INSTANCE = (VolumeManagerDLL) Native.loadLibrary("VolumeManager.dll", VolumeManagerDLL.class);


    boolean _Z12ChangeVolumefPKc(float deltaVolume, String programId);

    private boolean changeVolume(float deltaVolume, String programId)
    {
        return _Z12ChangeVolumefPKc(deltaVolume, programId);
    }
}
