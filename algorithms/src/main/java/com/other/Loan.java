package com.other;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zuoxiaolong5 on 2018/5/3.
 */
public class Loan {
    public static void main(String[] args) {

        double amount = 420000d; // 总额
        int months = 240; // 贷款时间
        double payed = 0d;// 已还本金
        double rate = 0.0540 / 12.0;// 初始利率
        double monthPay = amount / months;// 每月还款本金
        double totalInterest = 0.0;// 已还利息

        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM" );
        DecimalFormat df = new java.text.DecimalFormat( "##,##0.00" );
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, 2015 );
        cal.set( Calendar.MONTH, 7 );
        for ( int i = 0; i < months; i++ ) {
            if ( cal.get( Calendar.YEAR ) >= 2016 )
                rate = 0.0490 / 12.0; // 16年后新利率
            payed = i * monthPay; // 已还本金
            double monthInterest = ( amount - payed ) * rate; // 当月利息
            double monthAmount = monthPay + monthInterest; // 每月总还款额
            totalInterest += monthInterest; // 已产生总利息
            String result = String.format("%s 还款 %s 元, 当月利息 %s元 已还总利息 %s元",
                    format.format( cal.getTime()), df.format( monthAmount),
                    df.format( monthInterest ), df.format( totalInterest ));
            System.out.println( result);
            cal.add( Calendar.MONTH, 1 );
        }
    }
}
