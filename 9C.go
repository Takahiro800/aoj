package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

var (
	A []int
)

func main() {
	A = make([]int, 0)
	for {
		s := Read()
		if s == "end" {
			return
		} else if s == "insert" {
			key := ReadInt()
			insert(key)
		} else if s == "extract" {
			fmt.Println(extract())
		}
	}
}

func extract() int {
	maxV := A[0]
	A[0] = A[len(A)-1]
	A = A[:len(A)-1]
	maxHeapify(0)

	return maxV
}

func insert(key int) {
	A = append(A, key)
	i := len(A) - 1
	parent := parentIndex(i)
	for parent >= 0 && A[parent] < key {
		A[i], A[parent] = A[parent], A[i]
		i = parent
		parent = parentIndex(i)
	}
}

func parentIndex(i int) int {
	return (i - 1) / 2
}

func maxHeapify(i int) {
	l := 2*i + 1
	r := 2*i + 2
	biggest := i
	if l < len(A) && A[l] > A[biggest] {
		biggest = l
	}
	if r < len(A) && A[r] > A[biggest] {
		biggest = r
	}

	if biggest != i {
		A[i], A[biggest] = A[biggest], A[i]
		maxHeapify(biggest)
	}
}

// snipet

// INF_BIT60 = 1 << 60
var sc = bufio.NewScanner(os.Stdin)

func input() string {
	sc.Scan()
	return sc.Text()
}

func init() { sc.Buffer(make([]byte, 256), 1e9); sc.Split(bufio.ScanWords) }

func Read() string { sc.Scan(); return sc.Text() }
func ReadInt() int {
	v, e := strconv.Atoi(Read())
	if e != nil {
		panic(e.Error())
	}
	return v
}
func ReadString() string {
	if !sc.Scan() {
		panic(sc.Err())
	}
	return sc.Text()
}

func ReadIntSlice(n int) []int {
	b := make([]int, n)
	for i := 0; i < n; i++ {
		b[i] = ReadInt()
	}
	return b
}

func ReadFloatSlice(n int) []float64 {
	b := make([]float64, n)
	for i := 0; i < n; i++ {
		b[i] = ReadFloat()
	}
	return b
}

func ReadFloat() float64 {
	v, e := strconv.ParseFloat(Read(), 64)
	if e != nil {
		panic(e.Error())
	}
	return v
}
func judgeInt(x float64) bool {
	if math.Floor(x) == x {
		return true
	}
	return false
}
