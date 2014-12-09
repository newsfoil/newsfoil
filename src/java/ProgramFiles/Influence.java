/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

/**
 *
 * @author dentm_000
 */
public class Influence {
    
    private String ratingNumber;
    private int count;
    private int average;
    private int variance;
    private int distribution;
    private static int[] rating = new int[20];
    
    /* 
    Rating consists of a 22 digit number.  First two number is for the location of the 
    rating, the next twenty are the 20 most recient ratings.
    
    Number starts with: 0055555555555555555555
    
    */

    public String getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(String ratingNumber) {
        
        
        count = Integer.parseInt(ratingNumber.substring(0, 2));
        
       for (int x=0; x< rating.length; x++){
       
       rating[x] = Integer.parseInt(ratingNumber.substring(x+2, x+3));
       
       }
        
        this.ratingNumber = ratingNumber;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getVariance() {
        return variance;
    }

    public void setVariance(int variance) {
        this.variance = variance;
    }

    public int getDistribution() {
        return distribution;
    }

    public void setDistribution(int distribution) {
        this.distribution = distribution;
    }
    
    
    
}
