class Solution {
    public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            int twenty = 0;
            boolean ans = true;
            int i = 0;
            
            while(i < bills.length ){
                 if(bills[i] == 5){
                    five++;
                 }
                 else if(bills[i] == 10){
                    if(five >= 1){
                        ten++;
                        five--;
                    }
                    else{
                        ans = false; break;
                    } 
                }
                else if(bills[i] == 20){
                    if(ten >= 1 && five >= 1){
                        ten--;
                        five--;  
                    }
                    else if(five >= 3){
                        five -= 3;
                    }
                    else{
                        ans = false; break;
                    }
                }
                i++;
            }
            return ans;
    }
    
}