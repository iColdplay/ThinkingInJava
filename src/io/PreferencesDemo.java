package io;

import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws Exception{
        Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
        preferences.put("Location", "Shanghai");
        preferences.put("Company", "Agold");
        preferences.putInt("Life", 1);
        preferences.putBoolean("Love", false);
        int usage = preferences.getInt("Usage", 0);
        usage ++;
        preferences.putInt("Usage", usage);
        for(String key : preferences.keys()){
            System.out.println(key + ": " + preferences.get(key, null));
        }
    }
}
