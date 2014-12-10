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
    public Influence(String ratingNumber) {
        setRatingNumber(ratingNumber);
    }
    
    public void setNewRating(int newRating){
    addCount();
    rating[getCount()]=newRating;
    setRatingNumber();
    }
    
    public int getCount() {
        return count;   
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    private void addCount(){
    int tempcount = getCount();
    tempcount++;
    
    if (tempcount < 19)
        tempcount =0;
    setCount(tempcount);
    }

    public static int[] getRating() {
        return rating;
    }
    
    public static int getRating(int x) {
        return rating[x];
    }

    public static void setRating(int[] rating) {
        Influence.rating = rating;
    }

    public String getRatingNumber() {

        if (count < 10) {
            ratingNumber = "0" + Integer.toString(count);
        } else {
            ratingNumber = Integer.toString(count);
        }
        for (int x = 0; x < 20; x++) {
            ratingNumber = ratingNumber + Integer.toString(rating[x]);
        }
        return ratingNumber;
    }

    private void setRatingNumber() {
        
       int[] varianceTest ={0,0,0,0,0,0,0,0,0,0}; 
       int total=0; 
       int distributionCount =0;
       setCount(Integer.parseInt(ratingNumber.substring(0, 2)));
       
       for (int x=0; x< rating.length; x++){
        total = total +rating[x] +1;
        varianceTest[rating[x]]++; 
       }
       for (int x=0; x< varianceTest.length; x++)
       {
       if (varianceTest[x]> 2)
       {distributionCount = distributionCount + (5*(varianceTest[x]-2)); 
       
       } else if (varianceTest[x]== 0){
       distributionCount = distributionCount + 10;
       }
       else if (varianceTest[x]== 1){
       distributionCount = distributionCount + 5;
       }    
       }
       setAverage(total/20);
       
       if (total/20 == 5)
       setVariance(100);
       if ((total/20) > 5)
        setVariance(100-((total/20-5)*20)); 
       if ((total/20) < 5)
       setVariance(100-((5-total/20)*20));
       setDistribution(100 - distributionCount);
       
    }

    private void setRatingNumber(String ratingNumber) {
        
       int[] varianceTest ={0,0,0,0,0,0,0,0,0,0}; 
       int total=0; 
       int distributionCount =0;
       setCount(Integer.parseInt(ratingNumber.substring(0, 2)));
       
       
       for (int x=0; x< 20; x++){
        rating[x] = Integer.parseInt(ratingNumber.substring(x+2, x+3));
        total = total +rating[x] +1;
        varianceTest[rating[x]]++; 
       }
       for (int x=0; x< varianceTest.length; x++)
       {
       if (varianceTest[x]> 2)
       {distributionCount = distributionCount + (5*(varianceTest[x]-2)); 
       
       } else if (varianceTest[x]== 0){
       distributionCount = distributionCount + 10;
       }
       else if (varianceTest[x]== 1){
       distributionCount = distributionCount + 5;
       }    
       }
       setAverage(total/20);
       
       if (total/20 == 5)
       setVariance(100);
       if ((total/20) > 5)
        setVariance(100-((total/20-5)*20)); 
       if ((total/20) < 5)
       setVariance(100-((5-total/20)*20));
       setDistribution(100 - distributionCount);
       
    }

    public int getAverage() {
        return average;
    }

    private void setAverage(int average) {
        this.average = average;
    }

    public int getVariance() {
        return variance;
    }

    private void setVariance(int variance) {
        this.variance = variance;
    }

    public int getDistribution() {
        return distribution;
    }

    private void setDistribution(int distribution) {
        this.distribution = distribution;
    }
    
    
    
}
