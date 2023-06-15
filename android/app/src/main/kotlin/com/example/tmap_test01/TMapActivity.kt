package com.example.tmap_test01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.exoplayer2.util.Log
import com.skt.tmap.engine.navigation.network.ndds.NddsDataType
import com.skt.tmap.engine.navigation.route.RoutePlanType
import com.tmapmobility.tmap.tmapsdk.ui.fragment.NavigationFragment
import com.tmapmobility.tmap.tmapsdk.ui.util.TmapUISDK

class TMapActivity : AppCompatActivity() {
    private val CLIENT_ID = ""
    private val API_KEY = "ZnINGpNHay1u0hQiC2YNL3W5LBdKdK4NsCAlGT50" //발급받은 API 키
    private val USER_KEY = ""

    private lateinit var fragmentManagers: FragmentManager
    private lateinit var navigationFragment: NavigationFragment
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmap)
    }

    private fun initUI() {
        fragmentManagers = supportFragmentManager
        navigationFragment = TmapUISDK.getFragment()

        transaction = fragmentManagers.beginTransaction()
        transaction.add(R.id.tmapContainer, navigationFragment)
        transaction.commitAllowingStateLoss()
    }

    private fun initSDK() {
        TmapUISDK.initialize(
                this,
                CLIENT_ID,
                API_KEY,
                USER_KEY,
                // 앱 초기화 완료 시 호출되는 인터페이스
                object : TmapUISDK.InitializeListener {
                    override fun onSuccess() {
                        Log.e("FLUTTER TMAP", "success initialize")
                        navigationFragment.drivingStatusCallback = drivingStatusCallback
                    }

                    override fun onFail(p0: Int, p1: String?) {
                        Log.e("FLUTTER TMAP", "fail ${p0} -- ${p1}")
                    }
                })
        }

    // 운전 상태 변화 시 호출되는 인터페이스
    private val drivingStatusCallback = object : TmapUISDK.DrivingStatusCallback {
        // 내비게이션 시작 시 호출
        override fun onStartNavigation() {

        }

        // 내비게이션 종료 시 호출
       override fun onStopNavigation() {

        }

        // 권한 에러 발생 시 호출
        override fun onPermissionDenied(p0: Int, p1: String?) {

        }

        // 목적지 도착 시 호출
        override fun onArrivedDestination(dest: String, drivingTime: Int, drivingDistance: Int) {
        // dest : 목적지 명
        // drivingTime : 운전 시간
        // drivingDistance : 운전 거리
        }

        // 경로 이탈 재탐색 발생 시점에 호출
        override fun onBreakawayFromRouteEvent() {

        }

        // 대안 경로 접근 시 호출
        override fun onApproachingAlternativeRoute() {

        }

        // 대안 경로 통과 시 호출
        override fun onPassedAlternativeRouteJunction() {

        }

        // 정주기 재탐색 발생 시점에 호출
        override fun onPeriodicReroute() {

        }

        // 경로 변경 완료 시 호출
        override fun onRouteChanged(p0: Int) {

        }

        // 경로 재탐색 발생 시점에 호출
        override fun onForceReroute(p0: NddsDataType.DestSearchFlag) {

        }

        // GPS 상태 변화 시점에 호출
        override fun onNoLocationSignal(p0: Boolean) {

        }

        // 경유지 접근 시점에 호출 (1km 이내)
        override fun onApproachingViaPoint() {

        }

        // 경유지 통과 시 호출
        override fun onPassedViaPoint() {

        }

        // 경로 옵션 변경 완료 시 호출
        override fun onChangeRouteOptionComplete(p0: RoutePlanType) {

        }

        //경로 이탈 재탐색 동작 완료 시점에 호출
        override fun onBreakAwayRequestComplete() {

        }

        // 정주기 재탐색 동작 완료 시 호출
        override fun onPeriodicRerouteComplete() {

        }

        // 사용자 재탐색 동작 완료 시 호출
        override fun onUserRerouteComplete() {

        }

        // 건너편 안내 동작 탐색 완료 시점에 호출
        override fun onDestinationDirResearchComplete() {

        }

        //미리 종료 안내 동작 탐색 완료 시점에 호출
        override fun onDoNotRerouteToDestinationComplete() {

        }

        //경로 탐색 실패 시 호출
        override fun onFailRouteRequest(errorCode: String, errorMsg: String) {

        }

        // 톨게이트 통과 시 호출
        // cost : 요금
        override fun onPassedTollgate(cost: Int) {

        }

        //위치 갱신 때 마다 호출
        override fun onLocationChanged() {

        }


    }
}