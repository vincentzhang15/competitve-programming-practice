var line1 = process.argv[2];
var line2 = process.argv[3];
var line3 = process.argv[4];

var n = parseInt(line1, 10);
var b = line2.trim().split(' ').map(Number);
var h = line3.trim().split(' ').map(Number);

var ans = 0;
for(var i=0; i<n; i++)
{
    ans += (b[i] + b[i+1]) * h[i];
}

console.log(ans / 2);

// node CrazyFencing.js 3 "2 3 6 2" "4 1 1"

/*
// SUBMISSION

var line1 = gets(); // process.argv[2];
var line2 = gets(); // process.argv[3];
var line3 = gets(); // process.argv[4];

var n = parseInt(line1, 10);
var b = line2.trim().split(' ').map(Number);
var h = line3.trim().split(' ').map(Number);

var ans = 0;
for(var i=0; i<n; i++)
{
    ans += (b[i] + b[i+1]) * h[i];
}

print(ans / 2);
*/