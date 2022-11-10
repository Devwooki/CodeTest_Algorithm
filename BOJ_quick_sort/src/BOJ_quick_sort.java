public class BOJ_quick_sort {
    public static void main(int[] a) {
        //피벗을 기준으로 2개의 부분 리스트 생성, 작은거,큰거
        //재귀적 수행
        // 비교정렬이며 제자리 정렬
        // 왼쪽 피벗 선택
        l_pivot_sort(a, 0, a.length -1);
    }
    private static void l_pivot_sort(int[] a, int lo, int hi){
        //lo >= hi : 정렬할 원소가 1개 이하이므로 정렬하지 않음 return
        if(lo >= hi) return;
        /*
        피벗 기준으로 요소들이 왼쪽과 오른쪽에  약하게 정렬 후 pivot과 위치교환
        이후  피벗 기준으로 왼쪽리스트, 오른쪽 리스트와 나눠 분할 정복

        partitioning :
        *   a[left]          left part              right part
		 * +---------------------------------------------------------+
		 * |  pivot  |    element <= pivot    |    element > pivot   |
		 * +---------------------------------------------------------+
		 *
		 *
		 *  result After Partitioning:
		 *
		 *         left part          a[lo]          right part
		 * +---------------------------------------------------------+
		 * |   element <= pivot    |  pivot  |    element > pivot    |
		 * +---------------------------------------------------------+

		 result : pivot = lo
		 *
		 *
		 *  Recursion:
		 *
		 * l_pivot_sort(a, lo, pivot - 1)     l_pivot_sort(a, pivot + 1, hi)
		 *
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |    pivot    |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * lo                pivot - 1        pivot + 1                 hi
         */
        int pivot = partition(a, lo, hi);
        l_pivot_sort(a, lo, pivot-1);
        l_pivot_sort(a, pivot+1, hi);
    }
    //a 정렬 할 배열, left : 가장 왼쪽, right : 가장 오른쪽, return : 최종 피벗의 위치(lo)를 반환
    private static  int partition(int[] a,int left, int right){
        int lo = left;
        int hi = right;
        int pivot =  a[left]; //부분 리스트 왼쪽을 피봇으로

        while(lo < hi){
            //hi > lo 이고, hi 요소중 pivot보다 작거나 같으면  hi--
            while(a[hi] > pivot && lo < hi){
                hi--;
            }

            // hi > lo, lo 요소가  pivot보다 트면  lo++
            while(a[lo] <= pivot && lo < hi){
                lo++;
            }

            //마지막연산, 맨 처음  pivot으로 설정한 a[left]원소와 lo가 가르키는 원소 바꿈
            swap(a, left, lo);

        }
        return lo;
    }

    private static void swap(int[] a, int  i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}