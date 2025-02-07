package com.abdolphininfratech.app;
import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesManager {
    //app login variables
    private static final String PREF_NAME = "com.hmgreencity.PREF";
    private static final String Full_Name = "Full_Name";
    private static final String UserId = "UserId";
    private static final String UserType = "UserType";
    private static final String ProfilePic = "ProfilePic";
    private static final String Contact = "Contact";
    private static final String Token = "Token";
    private static final String LoginId = "LoginId";
    private static final String Password = "Password";
    private static final String Email = "Email";
    private static final String producyInfoId = "producyInfoId";
    private static final String vendorId = "vendorId";
    private static final String PK_VISITOR_ID = "PK_VisitorId";
    private static final String SiteID = "SiteID";
    private static final String SectorID = "SectorID";
    private static final String BlockID = "BlockID";
    private static final String CustomerID = "CustomerID";

    public static PreferencesManager sInstance;
    private final SharedPreferences mPref;
    private static Context context;

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_INTRO = "IS_FIRST_INTRO";

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    //for fragment
    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    //for getting instance
    public static synchronized PreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
        return sInstance;
    }

    public boolean clear() {
        return mPref.edit().clear().commit();
    }

    //Full_Name
    public void setProducyInfoId(String value) {
        mPref.edit().putString(producyInfoId, value).apply();
    }
    public String getProducyInfoId() {
        return mPref.getString(producyInfoId, "");
    }

    // Getters and Setters for CUSTOMER_ID
    public String getCustomerId() {
        return mPref.getString(CustomerID, "");
    }

    public void setCustomerId(String customerId) {
        mPref.edit().putString(CustomerID, customerId).apply();
    }

    // Getters and Setters for SITE_ID
    public String getSiteId() {
        return mPref.getString(SiteID, "");
    }

    public void setSiteId(String siteId) {
        mPref.edit().putString(SiteID, siteId).apply();
    }

    // Getters and Setters for SECTOR_ID
    public String getSectorId() {
        return mPref.getString(SectorID, "");
    }

    public void setSectorId(String sectorId) {
        mPref.edit().putString(SectorID, sectorId).apply();
    }

    // Getters and Setters for BLOCK_ID
    public String getBlockId() {
        return mPref.getString(BlockID, "");
    }

    public void setBlockId(String blockId) {
        mPref.edit().putString(BlockID, blockId).apply();
    }

    // PK Visitor ID
    public String getPkVisitorId() {
        return mPref.getString(PK_VISITOR_ID, "");
    }

    public void setPkVisitorId(String pkVisitorId) {
        mPref.edit().putString(PK_VISITOR_ID, pkVisitorId).apply();
    }

    //Email
    public void setEmail(String value) {
        mPref.edit().putString(Email, value).apply();
    }

    public String getEmail() {
        return mPref.getString(Email, "");
    }

    //UserId
    public void setVendorId(String value) {
        mPref.edit().putString(vendorId, value).apply();
    }

    public String getVendorId() {
        return mPref.getString(vendorId, "");
    }

    //Full_Name
    public void setFull_Name(String value) {
        mPref.edit().putString(Full_Name, value).apply();
    }

    public String getFull_Name() {
        return mPref.getString(Full_Name, "");
    }

    //UserId
    public void setUserId(String value) {
        mPref.edit().putString(UserId, value).apply();
    }

    public String getUserId() {
        return mPref.getString(UserId, "");
    }

    //UserType
    public void setUserType(String value) {
        mPref.edit().putString(UserType, value).apply();
    }

    public String getUserType() {
        return mPref.getString(UserType, "");
    }

    //ProfilePic
    public void setProfilePic(String value) {
        mPref.edit().putString(ProfilePic, value).apply();
    }

    public String getProfilePic() {
        return mPref.getString(ProfilePic, "");
    }

    //Contact
    public void setContact(String value) {
        mPref.edit().putString(Contact, value).apply();
    }

    public String getContact() {
        return mPref.getString(Contact, "");
    }

    //Token
    public void setToken(String value) {
        mPref.edit().putString(Token, value).apply();
    }

    public String getToken() {
        return mPref.getString(Token, "");
    }

    //LoginId
    public void setLoginId(String value) {
        mPref.edit().putString(LoginId, value).apply();
    }

    public String getLoginId() {
        return mPref.getString(LoginId, "");
    }

    //Password
    public void setPassword(String value) {
        mPref.edit().putString(Password, value).apply();
    }

    public String getPassword() {
        return mPref.getString(Password, "");
    }



    //IS_FIRST_TIME_LAUNCH
    public void setIsFirstTimeLaunch(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_TIME_LAUNCH, value).apply();
    }

    public boolean getIsFirstTimeLaunch() {
        return mPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    //setIsFirstIntro
    public void setIsFirstIntro(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_INTRO, value).apply();
    }

    public boolean getIsFirstIntro() {
        return mPref.getBoolean(IS_FIRST_INTRO, true);
    }

    public boolean logout(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }
}
