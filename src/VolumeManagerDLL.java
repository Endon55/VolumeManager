import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VolumeManagerDLL extends Library
{
    VolumeManagerDLL INSTANCE = (VolumeManagerDLL) Native.loadLibrary("VolumeManagerDLL.dll", VolumeManagerDLL.class);


    boolean _Z12ChangeVolumefbPKc(float deltaVolume, boolean add,  String programId);


}
