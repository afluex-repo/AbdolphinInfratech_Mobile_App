package com.abdolphininfratech.Activity;

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

import com.abdolphininfratech.Fragment.AssociateTree;
import com.abdolphininfratech.Fragment.BookingDetails;
import com.abdolphininfratech.Fragment.ChangePassword;
import com.abdolphininfratech.Fragment.Dashboard;
import com.abdolphininfratech.Fragment.Downline;
import com.abdolphininfratech.Fragment.Enquery;
import com.abdolphininfratech.Fragment.Ledger;
import com.abdolphininfratech.Fragment.PayoutDetails;
import com.abdolphininfratech.Fragment.PayoutLedger;
import com.abdolphininfratech.Fragment.PayoutRequest;
import com.abdolphininfratech.Fragment.PayoutRequestList;
import com.abdolphininfratech.Fragment.PlotAvailability;
import com.abdolphininfratech.Fragment.SummaryReport;
import com.abdolphininfratech.Fragment.UnpaidIncome;
import com.abdolphininfratech.Fragment.UserReword;
import com.abdolphininfratech.Fragment.ViewProfile;
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

        ReplaceFragment(new Dashboard(), "Dashboard");
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

        DrawerMenuItems(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.img_profile, R.id.tv_dashboard,
                R.id.tv_profile,   R.id.tv_payout_ledger,
                R.id.tv_payout_details,R.id.tv_plot_booking,R.id.tv_plot_availability,R.id.tv_payout_request,
                R.id.tv_associate_downline,R.id.tv_unpaid_income,R.id.tv_payout_requestList,R.id.tv_ledger,R.id.tv_summary_report,
                R.id.tv_user_reword,R.id.tv_change_password, R.id.tv_associate_tree,R.id.tv_enquiry, R.id.tv_logout})

        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.img_profile:
                    Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show();
                    //goToActivity(ContainerActivity.this, Profile.class, null);
                    break;
                case R.id.tv_dashboard:
                    if (!(currentFragment instanceof Dashboard))
                        ReplaceFragment(new Dashboard(), "Dashboard");
                    break;
                case R.id.tv_profile:
                    if (!(currentFragment instanceof ViewProfile))
                        ReplaceFragment(new ViewProfile(), "Profile");
                    break;
                case R.id.tv_payout_request:
                    if (!(currentFragment instanceof PayoutRequest))
                        ReplaceFragment(new PayoutRequest(), "Payout Request");
                    break;
                case R.id.tv_payout_ledger:
                    if (!(currentFragment instanceof PayoutLedger))
                        ReplaceFragment(new PayoutLedger(), "Payout Ledger");
                    break;
                case R.id.tv_payout_details:
                    if (!(currentFragment instanceof PayoutDetails))
                        ReplaceFragment(new PayoutDetails(), "Payout Details");
                    break;
                case R.id.tv_plot_booking:
                    if (!(currentFragment instanceof BookingDetails))
                        ReplaceFragment(new BookingDetails(), "Plot Details ");
                    break;
                case R.id.tv_plot_availability:
                    if (!(currentFragment instanceof PlotAvailability))
                        ReplaceFragment(new PlotAvailability(), "Plot Availability");
                    break;
                case R.id.tv_ledger:
                    if (!(currentFragment instanceof Ledger))
                        ReplaceFragment(new Ledger(), "Ledger Report");
                    break;
                case R.id.tv_associate_downline:
                    if (!(currentFragment instanceof Downline))
                        ReplaceFragment(new Downline(), " Downline");
                    break;
                case R.id.tv_unpaid_income:
                    if (!(currentFragment instanceof UnpaidIncome))
                        ReplaceFragment(new UnpaidIncome(), " Unpaid Income");
                    break;
                case R.id.tv_payout_requestList:
                    if (!(currentFragment instanceof PayoutRequestList))
                        ReplaceFragment(new PayoutRequestList(), " Payout Request List");
                    break;
                case R.id.tv_summary_report:
                    if (!(currentFragment instanceof SummaryReport))
                        ReplaceFragment(new SummaryReport(), "Summary Report");
                    break;
                case R.id.tv_associate_tree:
                    if (!(currentFragment instanceof AssociateTree))
                        ReplaceFragment(new AssociateTree(), "Associate Tree");
                    break;
                case R.id.tv_user_reword:
                    if (!(currentFragment instanceof UserReword))
                        ReplaceFragment(new UserReword(), "User Reword");
                    break;
                case R.id.tv_enquiry:
                    if (!(currentFragment instanceof Enquery))
                        ReplaceFragment(new Enquery(), "Enquiry");
                    break;
                case R.id.tv_change_password:
                    if (!(currentFragment instanceof ChangePassword))
                        ReplaceFragment(new ChangePassword(), "Change Password ");
                    break;
                case R.id.tv_logout:
                    logoutDialog(context, Login.class);
                    break;
            }
            drawerLayout.closeDrawers();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (currentFragment instanceof Dashboard) {
            super.onBackPressed();
            finish();
        } else {
            ReplaceFragment(new Dashboard(), "Dashboard");
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
}
