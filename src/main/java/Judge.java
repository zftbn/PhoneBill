import java.util.Calendar;

public class Judge {
//    public static void main(String[] args) {
//        System.out.println(Week(2023,3,26));
//    }

    //判断某年某月某日为星期几
    public static int Week(int year, int month, int day) {
        // 使用Calendar类计算星期几
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);  // 注意，Calendar类的月份从0开始
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        int[] weekdays={7,1,2,3,4,5,6};
        return weekdays[weekday-1];
    }

    //春夏转换
    public static long Trans1(int month, int day, long min) {
        if (month == 3) {
            min = min - 60;
        }
        return min;
    }

    //夏秋转换
    public static long Trans2(int month, int day, long min) {
        if (month == 11) {
            if (day >= 1 && day <= 7) {
                min = min + 60;
            }
        }
        return min;
    }
}
