/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance;

import java.io.File;

/**
 * Class to test method execution speeds
 *
 * @author mikko
 */
public class Performance {

    long timeStart;
    long timeEnd;

    public long start() {
        this.timeStart = (int) System.currentTimeMillis();
        return timeStart;
    }

    public long end() {
        this.timeEnd = (int) System.currentTimeMillis();
        return timeEnd;
    }

    public long timeDifference() {
        return this.timeEnd - this.timeStart;
    }

    public String fileSizeInKiloBytes(File file) {
        return (double) file.length() / 1024 + " kb";
    }
}
