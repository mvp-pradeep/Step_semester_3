public class CategoryC {

    // L2. Best Time to Buy and Sell Stock
    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }


    // L3. Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }


    // L4. Merge Two Sorted Arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }


    // L5. Rotate Array
    public static int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }


    // Main method
    public static void main(String[] args) {

        // L2
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("L2 Max Profit: " + maxProfit(prices));


        // L3
        int[] nums = {1, 2, 3, 1};
        System.out.println("L3 Contains Duplicate: "
                + containsDuplicate(nums));


        // L4
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] merged = mergeSortedArrays(arr1, arr2);

        System.out.print("L4 Merged Array: ");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }

        System.out.println();


        // L5
        int[] rotateNums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] rotated = rotateArray(rotateNums, k);

        System.out.print("L5 Rotated Array: ");
        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i] + " ");
        }

        System.out.println();
    }
}