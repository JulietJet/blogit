package com.jahra.utils;

import java.text.SimpleDateFormat;

/**
 * @author a.vorushenko
 */
public final class ArticleUtils {

    private static SimpleDateFormat dateFormat;
    private static final char[] abcCyr =   {'/',' ','а','б','в','г','д','е', 'ё', 'ж',
            'з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц', 'ч',
            'ш',  'щ','ъ','ы','ь','э', 'ю', 'я','А','Б','В','Г','Д','Е', 'Ё', 'Ж',
            'З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч',
            'Ш',  'Щ','Ъ','Ы','Б','Э', 'Ю', 'Я'
            ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
            ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private static final String[] abcLat = {"/","_","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja"
            ,"A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja"
            ,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
            ,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    public static SimpleDateFormat getSimpleDateFormat() {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("dd/MM/yy");
        }
        return dateFormat;
    }


    public static String getUrl(String title){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < title.length(); i++) {
            for(int x = 0; x < abcCyr.length; x++ )
                if (title.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
        }
        return builder.toString();
    }
}
