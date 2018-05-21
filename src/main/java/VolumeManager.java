package src.main.java;/*
    This project is so I can mute, unmute, and change volume of programs via Hotkey.

    Uses
    https://github.com/kristian/system-hook


    Core audio api
 */


public class VolumeManager
{
    public static void main(String[] args)
    {


        //System.out.println("Status: " + status);
        GlobalHotkeys hk = new GlobalHotkeys("chrome.exe", .05f);
        hk.start();
        try
        {
            while (hk.getRunning())
            {
                Thread.sleep(128);
            }
        } catch (InterruptedException e)
        {}
        finally{
            hk.shutdown();
        }
    }
}

