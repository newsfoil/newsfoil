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
public final class Influence {
    
    private String ratingNumber;
    private int count;
    private double average;
    private double variance;
    private double distribution;
    private static double networkFactor;
    private double influenceTotal;
    private static int[] rating = new int[20];

   

     /*
    Rating consists of a 22 digit number.  First two number is for the location of the
    rating, the next twenty are the 20 most recient ratings.
    Number starts with: 0055555555555555555555
     */
    public Influence() {
        
        
    }
    
    public void setNewRating(int newRating){
    addCount();
    rating[getCount()]=newRating;
    setRatingNumber();
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

    public void setRatingNumber(int numberOfMembers) {
        System.out.println("**somthing wrong in here... ");
       try {
        setNetworkFactor(numberOfMembers); 
       int[] varianceTest ={0,0,0,0,0,0,0,0,0,0}; 
       int total=0; 
       int distributionCount =0;
       
       
       for (int x=0; x< rating.length; x++){
        total = total +rating[x] +1;
        varianceTest[rating[x]]++; 
       }
       for (int x=0; x< varianceTest.length; x++)
       {
       if (varianceTest[x]> 2)
       {distributionCount = distributionCount + (5 *(varianceTest[x]-2)); 
       
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
        else if ((total/20) > 5)
        setVariance(100-((total/20-5)*20)); 
        else if ((total/20) < 5)
       setVariance(100-((5-total/20)*20));
        
       setDistribution((200 - distributionCount)/2);
       
       setInfluenceTotal(((getVariance()+getDistribution())/2)*(getNetworkFactor()/100));
       
       } catch (Exception ex){
       
       
       }
      
    }
    public void setRatingNumber() {
         
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
       {distributionCount = distributionCount + (5 *(varianceTest[x]-2)); 
       
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
        else if ((total/20) > 5)
        setVariance(100-((total/20-5)*20)); 
        else if ((total/20) < 5)
       setVariance(100-((5-total/20)*20));
        
       setDistribution((200 - distributionCount)/2);
       
       setInfluenceTotal(((getVariance()+getDistribution())/2)*(getNetworkFactor()/100));
       
      
    }


    public void setRatingNumber(String RatingNumber) {
        
       ratingNumber = RatingNumber;
       int total=0; 
       setCount(Integer.parseInt(ratingNumber.substring(0, 2)));
      
       for (int x=0; x< 20; x++){
        rating[x] = Integer.parseInt(ratingNumber.substring(x+2, x+3));
        total = total +rating[x] +1;
        } 
    }

    public double getAverage() {
        return average;
    }

    private void setAverage(double average) {
        this.average = average;
    }

    public double getVariance() {
        return variance;
    }

    private void setVariance(int variance) {
        this.variance = variance;
    }

    public double getDistribution() {
        return distribution;
    }

    private void setDistribution(int distribution) {
        this.distribution = distribution;
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

     public double getNetworkFactor() {
        return networkFactor;
    }

    public void setNetworkFactor(int numberOfMembers) {
        
        this.networkFactor = 100 + (numberOfMembers * 5);
    }

    public double getInfluenceTotal() {
        return influenceTotal;
    }

    public void setInfluenceTotal(double influenceTotal) {
        this.influenceTotal = influenceTotal;
    }
    
}
