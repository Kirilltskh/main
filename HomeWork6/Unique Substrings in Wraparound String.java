class Solution {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int[] maxLengths = new int[26]; // Максимальная длина подстроки для каждой буквы
        int currentLength = 1;
        
        maxLengths[s.charAt(0) - 'a'] = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);
            
            // Проверяем, следуют ли символы друг за другом в алфавитном порядке
            if ((curr - prev == 1) || (prev == 'z' && curr == 'a')) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            
            // Обновляем максимальную длину для текущего символа
            int index = curr - 'a';
            maxLengths[index] = Math.max(maxLengths[index], currentLength);
        }
        
        // Суммируем все максимальные длины
        int result = 0;
        for (int length : maxLengths) {
            result += length;
        }
        
        return result;
    }
}
