#pragma once  

#ifdef Library_EXPORTS  
#define LibraryY_API __declspec(dllexport)   
#else  
#define Library_API __declspec(dllimport)   
#endif  



// Returns a + b  
DWORD __declspec(dllexport) GetProcessId(LPCTSTR ProcessName);

// Returns true if volume was sucessfully changed
bool __declspec(dllexport) ChangeVolume(float deltaVolume, bool add, LPCTSTR programId);

// Returns the new processVolume after adding deltaVolume 
float __declspec(dllexport) getVolumeAdd(float masterVolume, float processVolume, float deltaVolume);

// Returns the new processVolume after subtracting deltaVolume 
float __declspec(dllexport) getVolumeSub(float masterVolume, float processVolume, float deltaVolume);

/*
// Returns the new processVolume after multiplying deltaVolume 
float __declspec(dllexport) getVolumeMult(float masterVolume, float processVolume, float deltaVolume);

*/