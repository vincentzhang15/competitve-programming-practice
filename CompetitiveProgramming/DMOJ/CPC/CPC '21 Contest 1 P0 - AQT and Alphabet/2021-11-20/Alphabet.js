var s = process.argv[2];

for(let i =97; i<= 97+6; i++)
{
    let c = String.fromCharCode(i);
    if(s.indexOf(c) == -1)
    {
        console.log(c);
        break;
    }
}

// SUBMIT
/*
var s = gets();

for(let i =97; i<= 97+6; i++)
{
    let c = String.fromCharCode(i);
    if(s.indexOf(c) == -1)
    {
        print(c);
        break;
    }
}
*/