package com.abdolphininfratech.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.abdolphininfratech.Fragment.AdvancePaymentListFragment;
import com.abdolphininfratech.Fragment.AssociateBusinessFragment;
import com.abdolphininfratech.Fragment.AssociateTree;
import com.abdolphininfratech.Fragment.BookingDetails;
import com.abdolphininfratech.Fragment.BusinessDevelopmentFragment;
import com.abdolphininfratech.Fragment.ChangePassword;
import com.abdolphininfratech.Fragment.Dashboard;
import com.abdolphininfratech.Fragment.DownbusinessReportFragment;
import com.abdolphininfratech.Fragment.Downline;
import com.abdolphininfratech.Fragment.Enquery;
import com.abdolphininfratech.Fragment.Ledger;
import com.abdolphininfratech.Fragment.PayoutDetails;
import com.abdolphininfratech.Fragment.PayoutLedger;
import com.abdolphininfratech.Fragment.PayoutRequest;
import com.abdolphininfratech.Fragment.PayoutRequestList;
import com.abdolphininfratech.Fragment.PlotAvailability;
import com.abdolphininfratech.Fragment.SelfDownLineBusinessReportFragment;
import com.abdolphininfratech.Fragment.SummaryReport;
import com.abdolphininfratech.Fragment.UnpaidIncome;
import com.abdolphininfratech.Fragment.UserReword;
import com.abdolphininfratech.Fragment.ViewProfile;
import com.abdolphininfratech.Fragment.VisistorListFragment;
import com.abdolphininfratech.MainFragment;
import com.abdolphininfratech.R;
import com.abdolphininfratech.constants.BaseActivity;
import com.google.android.material.navigation.NavigationView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class ContainerActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerMenuItems drawerMenuItems;
    @BindView(R.id.img_side_menu)
    ImageButton imgSideMenu;
    @BindView(R.id.rl_clickmenu)
    RelativeLayout rlClickmenu;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);

        Toolbar containertoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(containertoolbar);
        navView.setNavigationItemSelectedListener(this);
        View hView = navView.getHeaderView(0);
        drawerMenuItems = new DrawerMenuItems(hView);

        ReplaceFragment(new MainFragment(), "Dashboard");

    }

    private Fragment currentFragment;

    public void ReplaceFragment(Fragment setFragment, String title) {
        new Handler().postDelayed(() -> {
            currentFragment = setFragment;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame, setFragment, title);
            tvTitle.setText(title);
            transaction.commitAllowingStateLoss();
        }, 200);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    class DrawerMenuItems {
        private boolean isSubMenuVisible = false;

        DrawerMenuItems(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.img_profile, R.id.tv_dashboard,R.id.submenu_item_1,R.id.subassociate_tree,R.id.subpayout_request,R.id.subuser_reword,R.id.subplot_availability,
                R.id.tv_profile,   R.id.tv_payout_ledger,R.id.maindashboard,R.id.tv_visitor_report,R.id.tv_payment_report,R.id.tv_associatebusiness_report,
                R.id.tv_payout_details,R.id.tv_plot_booking,R.id.tv_plot_availability,R.id.tv_payout_request,R.id.tv_downbusiness_report,R.id.tv_businessdevelopment_report,
                R.id.tv_associate_downline,R.id.tv_unpaid_income,R.id.tv_payout_requestList,R.id.tv_ledger,R.id.tv_summary_report,R.id.tv_selfdownline_report,
                R.id.tv_user_reword,R.id.tv_change_password, R.id.tv_associate_tree,R.id.tv_enquiry, R.id.tv_logout,R.id.kycUpload})

        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.img_profile:
                    Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.maindashboard:
                    if (!(currentFragment instanceof MainFragment))
                        ReplaceFragment(new MainFragment(), " Dashboard");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_dashboard:
                    if (!(currentFragment instanceof Dashboard))
                        ReplaceFragment(new Dashboard(), " Business Dashboard");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.submenu_item_1:
                    if (!(currentFragment instanceof ViewProfile)) {
                        ReplaceFragment(new ViewProfile(), "Sub Item 1");
                    }
                    drawerLayout.closeDrawers();
                    break;

                    // profile
                case R.id.tv_profile:
                    if (!(currentFragment instanceof ViewProfile))
                        ReplaceFragment(new ViewProfile(), "Profile");
                    drawerLayout.closeDrawers();
                    break;

                   //payout request
                case R.id.tv_payout_request:
                    if (isSubMenuVisible) {
                        hideSubMenu3();
                    } else {
                        showSubMenu3();
                    }
                    isSubMenuVisible = !isSubMenuVisible;
                    break;

                case R.id.subpayout_request:
                    if (!(currentFragment instanceof PayoutRequest))
                        ReplaceFragment(new PayoutRequest(), "Payout Request");
                    drawerLayout.closeDrawers();
                    break;

                    //payout ledger
                case R.id.tv_payout_ledger:
                    if (!(currentFragment instanceof PayoutLedger))
                        ReplaceFragment(new PayoutLedger(), "Payout Ledger");
                    drawerLayout.closeDrawers();
                    break;

                    //payout details
                case R.id.tv_payout_details:
                    if (!(currentFragment instanceof PayoutDetails))
                        ReplaceFragment(new PayoutDetails(), "Payout Details");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_plot_booking:
                    if (!(currentFragment instanceof BookingDetails))
                        ReplaceFragment(new BookingDetails(), "Plot Details ");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_plot_availability:
                    if (isSubMenuVisible) {
                        hideSubMenu4();
                    } else {
                        showSubMenu4();
                    }
                    isSubMenuVisible = !isSubMenuVisible;
                    break;
                case R.id.subplot_availability:
                    if (!(currentFragment instanceof PlotAvailability))
                        ReplaceFragment(new PlotAvailability(), "Plot Availability");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_ledger:
                    if (!(currentFragment instanceof Ledger))
                        ReplaceFragment(new Ledger(), "Ledger Report");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_associate_downline:
                    if (!(currentFragment instanceof Downline))
                        ReplaceFragment(new Downline(), " Downline");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_unpaid_income:
                    if (!(currentFragment instanceof UnpaidIncome))
                        ReplaceFragment(new UnpaidIncome(), " Unpaid Income");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_payout_requestList:
                    if (!(currentFragment instanceof PayoutRequestList))
                        ReplaceFragment(new PayoutRequestList(), " Payout Request List");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_summary_report:
                    if (!(currentFragment instanceof SummaryReport))
                        ReplaceFragment(new SummaryReport(), "Summary Report");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_visitor_report:
                    if (!(currentFragment instanceof VisistorListFragment))
                        ReplaceFragment(new VisistorListFragment(), "Visitor List");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_payment_report:
                    if (!(currentFragment instanceof AdvancePaymentListFragment))
                        ReplaceFragment(new AdvancePaymentListFragment(), "Advance Payment List");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_associatebusiness_report:
                    if (!(currentFragment instanceof AssociateBusinessFragment))
                        ReplaceFragment(new AssociateBusinessFragment(), "Associate Business");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_downbusiness_report:
                    if (!(currentFragment instanceof DownbusinessReportFragment))
                        ReplaceFragment(new DownbusinessReportFragment(), "Down Business Report");
                    drawerLayout.closeDrawers();
                    break;

                case R.id.tv_businessdevelopment_report:
                    if (!(currentFragment instanceof BusinessDevelopmentFragment))
                        ReplaceFragment(new BusinessDevelopmentFragment(), "Business Development");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_selfdownline_report:
                    if (!(currentFragment instanceof SelfDownLineBusinessReportFragment))
                        ReplaceFragment(new SelfDownLineBusinessReportFragment(), "Self DownLine Business Report");
                    drawerLayout.closeDrawers();
                    break;

                //associate tree
                case R.id.tv_associate_tree:
                    if (isSubMenuVisible) {
                        hideSubMenu1();
                    } else {
                        showSubMenu1();
                    }
                    isSubMenuVisible = !isSubMenuVisible;
                    break;
                case R.id.subassociate_tree:
                    if (!(currentFragment instanceof AssociateTree)) {
                        ReplaceFragment(new AssociateTree(), "Sub Item 1");
                    }
                    drawerLayout.closeDrawers();
                    break;

                    //// user Reward
                case R.id.tv_user_reword:
//
                    if (isSubMenuVisible) {
                        hideSubMenu2();
                    } else {
                        showSubMenu2();
                    }
                    isSubMenuVisible = !isSubMenuVisible;
                    break;
                case R.id.subuser_reword:
                    if (!(currentFragment instanceof UserReword))
                       ReplaceFragment(new UserReword(), "User Reward");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_enquiry:
                    if (!(currentFragment instanceof Enquery))
                        ReplaceFragment(new Enquery(), "Enquiry");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_change_password:
                    if (!(currentFragment instanceof ChangePassword))
                        ReplaceFragment(new ChangePassword(), "Change Password ");
                    drawerLayout.closeDrawers();
                    break;
                case R.id.tv_logout:
                    logoutDialog(context, Login.class);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.kycUpload:
                    Intent intent =new Intent(ContainerActivity.this,KYCUploadActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                    break;
            }
           // drawerLayout.closeDrawers();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (currentFragment instanceof MainFragment) {
            super.onBackPressed();
            finish();
        } else {
            ReplaceFragment(new MainFragment(), "Dashboard");
        }
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        }
    }

    @OnClick({R.id.img_side_menu, R.id.rl_clickmenu,R.id.img_profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_side_menu:
            case R.id.rl_clickmenu:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.img_profile:
                if (!(currentFragment instanceof ViewProfile))
                    ReplaceFragment(new ViewProfile(), "Profile");
        }

    }


    private void showSubMenu() {
        View subItem1 = findViewById(R.id.submenu_dashboard);
        View subItem2 = findViewById(R.id.TreeLayout);


        if (subItem1 != null) subItem1.setVisibility(View.VISIBLE);
        if (subItem2 != null) subItem2.setVisibility(View.VISIBLE);
    }


    private void showSubMenu1() {
        View subItem2 = findViewById(R.id.TreeLayout);
        View subItem3 = findViewById(R.id.TreeLayout1);
        if (subItem2 != null) subItem2.setVisibility(View.VISIBLE);
        if (subItem3 != null) subItem3.setVisibility(View.VISIBLE);
    }


    private void showSubMenu2() {
        View subItem2 = findViewById(R.id.userRewardLayout);
        if (subItem2 != null) subItem2.setVisibility(View.VISIBLE);
    }
    @SuppressLint("SuspiciousIndentation")
    private void showSubMenu3() {
        View subItem2 = findViewById(R.id.ledgerLayout);
         View subItem3 = findViewById(R.id.payoutLayout);
        View subItem4 = findViewById(R.id.payoutdetailsLayout);
        View subItem5 = findViewById(R.id.payoutrequestLayout);
        if (subItem2 != null) subItem2.setVisibility(View.VISIBLE);
          if (subItem3 != null) subItem3.setVisibility(View.VISIBLE);
        if (subItem4 != null) subItem4.setVisibility(View.VISIBLE);
        if (subItem5 != null) subItem5.setVisibility(View.VISIBLE);
    }


    private void showSubMenu4() {
        View subItem1 = findViewById(R.id.reportLayout);
        View subItem2 = findViewById(R.id.plotDetailsLayout);
        View subItem3 = findViewById(R.id.unpaidimcomeLayout);
        View subItem4 = findViewById(R.id.summeryreportLayout);
        View subItem5 = findViewById(R.id.advancePaymentportLayout);//done
        View subItem6 = findViewById(R.id.businessdevelopmentLayout);
        View subItem7= findViewById(R.id.selfdownlineLayout);//remove
        View subItem8 = findViewById(R.id.downbusinessLayout);//done
        View subItem9 = findViewById(R.id.associatebusinessLayout);//done
        View subItem10 = findViewById(R.id.VISITORLayout);//done


        if (subItem1 != null) subItem1.setVisibility(View.VISIBLE);
        if (subItem2 != null) subItem2.setVisibility(View.VISIBLE);
        if (subItem3 != null) subItem3.setVisibility(View.VISIBLE);
        if (subItem4 != null) subItem4.setVisibility(View.VISIBLE);
        if (subItem5 != null) subItem5.setVisibility(View.VISIBLE);
        if (subItem6 != null) subItem6.setVisibility(View.GONE);
        if (subItem7 != null) subItem7.setVisibility(View.VISIBLE);
        if (subItem8 != null) subItem8.setVisibility(View.VISIBLE);
        if (subItem9 != null) subItem9.setVisibility(View.VISIBLE);
        if (subItem10 != null) subItem10.setVisibility(View.VISIBLE);

    }



    //hide
    private void hideSubMenu() {
        View subItem1 = findViewById(R.id.submenu_dashboard);
        View subItem2 = findViewById(R.id.TreeLayout);

        if (subItem1 != null) subItem1.setVisibility(View.GONE);
        if (subItem2 != null) subItem2.setVisibility(View.GONE);
    }

    private void hideSubMenu1() {
        View subItem2 = findViewById(R.id.TreeLayout);
        View subItem3 = findViewById(R.id.TreeLayout1);
        if (subItem2 != null) subItem2.setVisibility(View.GONE);
        if (subItem3 != null) subItem3.setVisibility(View.GONE);
    }

    private void hideSubMenu2() {
        View subItem2 = findViewById(R.id.userRewardLayout);
      //  View subItem3 = findViewById(R.id.TreeLayout);
        if (subItem2 != null) subItem2.setVisibility(View.GONE);
        //if (subItem3 != null) subItem3.setVisibility(View.GONE);
    }

    private void hideSubMenu3() {
        View subItem2 = findViewById(R.id.ledgerLayout);
        View subItem3 = findViewById(R.id.payoutLayout);
        View subItem4 = findViewById(R.id.payoutdetailsLayout);
        View subItem5 = findViewById(R.id.payoutrequestLayout);
        if (subItem2 != null) subItem2.setVisibility(View.GONE);
        if (subItem3 != null) subItem3.setVisibility(View.GONE);
        if (subItem4 != null) subItem4.setVisibility(View.GONE);
        if (subItem5 != null) subItem5.setVisibility(View.GONE);
    }


    private void hideSubMenu4() {
        View subItem1 = findViewById(R.id.reportLayout);
        View subItem2 = findViewById(R.id.plotDetailsLayout);
        View subItem3 = findViewById(R.id.unpaidimcomeLayout);
        View subItem4 = findViewById(R.id.summeryreportLayout);
        View subItem5 = findViewById(R.id.advancePaymentportLayout);
        View subItem6 = findViewById(R.id.businessdevelopmentLayout);
        View subItem7= findViewById(R.id.selfdownlineLayout);
        View subItem8 = findViewById(R.id.downbusinessLayout);
        View subItem9 = findViewById(R.id.associatebusinessLayout);
        View subItem10 = findViewById(R.id.VISITORLayout);

        if (subItem1 != null) subItem1.setVisibility(View.GONE);
        if (subItem2 != null) subItem2.setVisibility(View.GONE);
        if (subItem3 != null) subItem3.setVisibility(View.GONE);
        if (subItem4 != null) subItem4.setVisibility(View.GONE);
        if (subItem5 != null) subItem5.setVisibility(View.GONE);
        if (subItem6 != null) subItem6.setVisibility(View.GONE);
        if (subItem7 != null) subItem7.setVisibility(View.GONE);
        if (subItem8 != null) subItem8.setVisibility(View.GONE);
        if (subItem9 != null) subItem9.setVisibility(View.GONE);
        if (subItem10 != null) subItem10.setVisibility(View.GONE);
    }

}
