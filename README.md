# Chess with customizable board
Custom chess board should be described in next format:

Board describes as a square of tokens.
Board cell can be blocked or with borders on sides, which cant be passed with figure.
## Cell tokens
| | Empty | Blocked | Up border | Down border | Left border | Right border |
| --- | --- | --- | --- | --- | --- | --- |
| Token | * | x | u | d | l | r |

## Figure tokens
| | King | Queen | Bishop | Knight | Rook | Pawn|
| --- | --- | --- | --- | --- | --- | --- |
| Black | bk | bq | bb | bh | br | bp |
| White | wk | wq | wb | wh | wr | wp |

Tokens should be separeted with spaces

### Example of board description
wr wp * * * * bp br\
wh wp * * * * bp bh\
wb wp * * * * bp bb\
wq wp * * * * bp bk\
wk wp * * * * bp bq\
wb wp * * * * bp bb\
wh wp * * * * bp bh\
wr wp * * * * bp br
