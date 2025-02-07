package com.abdolphininfratech.retrofit;
import com.abdolphininfratech.Model.AdvancePaymentList.ResAdvancePaymentList;
import com.abdolphininfratech.Model.AssociateDownline.ResponseAssociateDownline;
import com.abdolphininfratech.Model.Block.ResponseBlock;
import com.abdolphininfratech.Model.BusinessReport.ResBusinessReport;
import com.abdolphininfratech.Model.DownlineBusinessReport.ResDownlineBusinessReport;
import com.abdolphininfratech.Model.GetDownLineBusinessById.ResGetDownLineBusinessById;
import com.abdolphininfratech.Model.KYCUPLOAD.ResKYCUPLOAD;
import com.abdolphininfratech.Model.PrintVisitorList.ResPrintVisitorList;
import com.abdolphininfratech.Model.ResponseForgotPassword;
import com.abdolphininfratech.Model.ResponsePayoutRequest;
import com.abdolphininfratech.Model.ResponseSavePayout;
import com.abdolphininfratech.Model.ResponseUpdateProfile;
import com.abdolphininfratech.Model.ResponseViewProfile;
import com.abdolphininfratech.Model.Sector.ResponseSector;
import com.abdolphininfratech.Model.SelfDownlineBusinessReport.ResSelfDownlineBusinessReport;
import com.abdolphininfratech.Model.Site.ResponseSite;
import com.abdolphininfratech.Model.SiteType.ResponseSiteType;
import com.abdolphininfratech.Model.UploadKycList.ReqUploadKycList;
import com.abdolphininfratech.Model.UploadKycList.ResUploadKycList;
import com.abdolphininfratech.Model.VisitorList.ResVisitorList;
import com.abdolphininfratech.Model.request.RequestBookingDetails;
import com.abdolphininfratech.Model.request.RequestPlotAvailability;
import com.abdolphininfratech.Model.request.RequestUpdateProfile;
import com.abdolphininfratech.Model.responseAssociateTree.ResponseAssociateTree;
import com.abdolphininfratech.Model.responseBookingDetails.ResponseBookingDetails;
import com.abdolphininfratech.Model.responseDashboard.ResponseDashboard;
import com.abdolphininfratech.Model.responseDownline.ResponseDownline;
import com.abdolphininfratech.Model.responseEnquiry.ResponseEnquriy;
import com.abdolphininfratech.Model.responseEnquryList.ResponsEnqueryList;
import com.abdolphininfratech.Model.responseLedger.ResponseLedger;
import com.abdolphininfratech.Model.responseLogin.ResponseLogin;
import com.abdolphininfratech.Model.responseNews.ResponseNews;
import com.abdolphininfratech.Model.responsePayoutDetails.ResponsePayoutDetails;
import com.abdolphininfratech.Model.responsePayoutLedger.ResponsePayoutLedger;
import com.abdolphininfratech.Model.responsePayoutRequestList.ResponsePayoutRequestList;
import com.abdolphininfratech.Model.responsePlotAvability.ResponsePlotAvailability;
import com.abdolphininfratech.Model.responseSummsryReport.ResponseSummaryReport;
import com.abdolphininfratech.Model.responseUnpaidIncome.ResponseUnpaidIncome;
import com.abdolphininfratech.Model.responseUserReword.ResponseUserReword;
import com.google.gson.JsonObject;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiServices {

    @POST("WebAPI/Login")
    Call<ResponseLogin> getLogin(@Body JsonObject login);

    @POST("WebAPI/GettownshipbookingDetails")
    Call<ResponseLogin> GettownshipbookingDetails();

    @POST("WebAPI/ForgetPass")
    Call<ResponseForgotPassword> getForgotPassword(@Body JsonObject login);

    @POST("WebAPI/GetTotalForAssociateDashBoard")
    Call<ResponseDashboard> getDashboard(@Body JsonObject login);

    @POST("WebAPI/GetNewsDetailsForAssociateDashBoard")
    Call<ResponseNews>getNews(@Body JsonObject login);

    @POST("WebAPI/ViewProfile")
    Call<ResponseViewProfile>getViewProfile(@Body JsonObject login);

    @POST("WebAPI/UpdateProfile")
    Call<ResponseUpdateProfile>getUpdateProfile(@Body RequestUpdateProfile login);

    @POST("WebAPI/PayoutLedger")
    Call<ResponsePayoutLedger>getPayoutLedger(@Body JsonObject login);

    @POST("WebAPI/PayoutRequest")
    Call<ResponsePayoutRequest>getPayoutRequest(@Body JsonObject login);
    @POST("WebAPI/PayoutDetails")
    Call<ResponsePayoutDetails>getPayoutDetails(@Body JsonObject login);

    @POST("WebAPI/BookingList")
    Call<ResponseBookingDetails>getBookingDetails(@Body RequestBookingDetails login);

    @POST("WebAPI/PlotAvailability")
    Call<ResponsePlotAvailability>getPlotAvailability(@Body RequestPlotAvailability login);

    @POST("WebAPI/AssociateDownlineDetail")
    Call<ResponseDownline>getDownline(@Body JsonObject login);

    @POST("WebAPI/UnpaidIncome")
    Call<ResponseUnpaidIncome>getUnpaidIncome(@Body JsonObject login);

    @POST("WebAPI/PayoutRequestReport")
    Call<ResponsePayoutRequestList>getPayoutRequestReportList(@Body JsonObject login);

    @POST("WebAPI/Details")
    Call<ResponseLedger>getLedger(@Body JsonObject login);

    @POST("WebAPI/GetSummaryReport")
    Call<ResponseSummaryReport>getSummaryReport(@Body JsonObject login);

    @POST("WebAPI/UserReward")
    Call<ResponseUserReword>getUserReword(@Body JsonObject login);

    @POST("WebAPI/AssociateTree")
    Call<ResponseAssociateTree>getAssociateTree(@Body JsonObject login);

    @POST("WebAPI/GetSiteType")
    Call<ResponseSiteType>getSiteType();

    @POST("WebAPI/GetSite")
    Call<ResponseSite>getSite();

    @POST("WebAPI/GetSector")
    Call<ResponseSector>getSector(@Body JsonObject login);

    @POST("WebAPI/GetBlock")
    Call<ResponseBlock>getBlock(@Body JsonObject login);

    @POST("WebAPI/SaveEnquiry")
    Call<ResponseEnquriy>getEnquiry(@Body JsonObject login);
    @POST("WebAPI/EnquiryList")
    Call<ResponsEnqueryList>getEnquriyList(@Body JsonObject login);

    @Multipart
    @POST("api/ImageUpload/user/PostUserImage")
    Call<JsonObject> uploadProfilePic(@Part("fk_UserId") RequestBody fk_UserId,
                                                 @Part() MultipartBody.Part file);
    @POST("WebAPI/SavePayoutRequest")
    Call<ResponseSavePayout>SavePayout(@Body JsonObject login);

// kYC UPLOAD
    @Multipart
    @POST("WebAPI/KYCDocuments")
    Call<ResKYCUPLOAD> UploadKyc(
            @Part("UserID") RequestBody userID,
            @Part("DocumentNumber") RequestBody documentNumber,
            @Part("PanNumber") RequestBody panNumber,
            @Part("AdharNumber") RequestBody adharNumber,
            @Part("AccountHolderName") RequestBody accountHolderName,
            @Part("BankName") RequestBody bankName,
            @Part("IFSCCode") RequestBody ifscCode,
            @Part("BankBranch") RequestBody bankBranch,
            @Part MultipartBody.Part adharImage,
            @Part MultipartBody.Part adharBacksideImage,
            @Part MultipartBody.Part panImage,
            @Part MultipartBody.Part documentImage

    );

    @POST("WebAPI/GetKYCList")
    Call<ResUploadKycList> getKYCList(@Body ReqUploadKycList requestObject);

    @POST("WebAPI/VisitorList")
    Call<ResVisitorList> getVisitorList(@Body JsonObject requestObject);

    @POST("WebAPI/PrintVisitor")
    Call<ResPrintVisitorList> getprintVisitor(@Body JsonObject requestObject);

    @POST("WebAPI/AdvancePaymentList")
    Call<ResAdvancePaymentList> getAdavncePaymentList(@Body JsonObject requestObject);

    @POST("WebAPI/BusinessReport")
    Call<ResBusinessReport> getBusinessReport(@Body JsonObject requestObject);

    @POST("WebAPI/DownBusinessReport")
    Call<ResDownlineBusinessReport> getDownBusinessReport(@Body JsonObject requestObject);

    @POST("WebAPI/GetDownLineBusinessById")
    Call<ResGetDownLineBusinessById> getdownBusiness(@Body JsonObject requestObject);

    @POST("WebAPI/GetSelfDownlineBusinessReport")
    Call<ResSelfDownlineBusinessReport> getselfdownlinebusiness(@Body JsonObject requestObject);


    @POST("WebAPI/GetDownLineReports")
    Call<ResponseAssociateDownline> getAssociatedownline(@Body JsonObject requestObject);


}