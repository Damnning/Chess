# Chess with customizable board
## Direction tokens
|       | Up | Right | Down | Left |
|-------|----|-------|------|------|
| Token | u  | r     | d    | l    |

Custom chess board should be described in next format:
Firstly file should contain description players' pawns directions. It's described in next format:\
'0_d\
1_u'\
Numbers here represent player number. Description should contain numbers from 0 till 9. These number should coincide with numbers in figure tokens.\
Description of board and pawns directions should be separated with three dashes:\
'---'\
Board describes as a square of tokens.
Board cell can be blocked or with borders on sides, which cant be passed with figure.
## Cell tokens
|       | Empty | Blocked | Up border | Down border | Left border | Right border |
|-------|-------|---------|-----------|-------------|-------------|--------------|
| Token | *     | x       | u         | d           | l           | r            |

## Figure tokens
|       | King | Queen | Bishop | Horse | Tower | Pawn |
|-------|------|-------|--------|-------|-------|------|
| Token | k    | q     | b      | h     | t     | p    |

Entire token consists of parts described before

If cell is empty or blocked token contains only "*" or "x"\
If cell has only border token contains only "u", "d", "l" or "r"\
If cell has only figure token contains number firstly from 0 to 9, which represent player, and secondly figure token.\
Example: '0k', '1q'.\
If cell has figure and border token contains firstly and secondly player and figure tokens and then border token.
Example: '1pu', '0qr'

Tokens should be separated with underscores

### Example of board description
```
0r_0p_*_*_*_*_1p_1r
0h_0p_*_*_*_*_1p_1h
0b_0p_*_*_*_*_1p_1b
0q_0p_*_*_*_*_1p_1k
0k_0p_*_*_*_*_1p_1q
0b_0p_*_*_*_*_1p_1b
0h_0p_*_*_*_*_1p_1h
0r_0p_*_*_*_*_1p_1r
```
