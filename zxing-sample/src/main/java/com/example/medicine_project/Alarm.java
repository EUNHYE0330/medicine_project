package com.example.medicine_project;

// 이것들로 날짜와 시간, 요일을 다룬다
import java.time.LocalDateTime;

// ===================== 요구사항 ==============================
/*
*
* 알림 테이블에는 알람 인스턴스 하나만 추가하면 됩니다 ( 열column 두개임 , 1,Aid 2, Alarm )
*
* 생성, 읽기, 수정 삭제 기능을 코드상에서 구현해주세요( 레이아웃 없어도 됨 )
*
* */

public class Alarm {
    private Drug drug;
    private boolean[] date = new boolean[7]; // 요일
    private LocalDateTime[] time = new LocalDateTime[3]; //맘에드는클래스로..., 하루에 세번 까지...
    private double volume; // 약 먹는 양, 반개 허용, 최대 3알
    private String memo;

    private boolean enabled = false;    // 알림 설정 여부

    public Alarm() {

    }

    // 수기 작성 화면에서 입력받은 내용으로 알림 설정 객체 생성
    // 약 이름만 일단 객체로 만들게 작성했고
    // 나머지 필드도 채워야 함
    public Alarm(String drugName) {
        drug = new Drug(drugName);
    }
    /*public Alarm(Drug drug, p2, p3. ...) {

    }*/

    public Drug getDrug() {
        return drug;
    }
    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public boolean[] getDate() {
        return date;
    }

    public void setDate(boolean[] date) {
        this.date = date;
    }

    public LocalDateTime[] getTime() {
        return time;
    }

    public void setTime(LocalDateTime[] time) {
        this.time = time;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
