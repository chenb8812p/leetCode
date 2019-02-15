func lengthOfLongestSubstring(s string) int {
	pathMap := make(map[byte]int, len(s) * 2)

	maxLong := 0
	i := 0
	for ind, _ := range s{
		c := s[ind]
		if pathMap[c] != 0 {
			if i < pathMap[c] {
				i = pathMap[c]
			}
		}
		if ind - i + 1 > maxLong {
			maxLong = ind - i + 1
		}
		pathMap[c] = ind + 1
	}
	return maxLong
}
