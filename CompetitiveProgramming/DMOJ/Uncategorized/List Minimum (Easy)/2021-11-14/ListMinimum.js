inputString = process.argv[2]

var n = parseInt(inputString, 10);

var s = "";
for(let i=1; i<=n; i++)
{
    s += i + " ";
}
process.stdout.write(s);
