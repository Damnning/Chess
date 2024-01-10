Checks that are required by move are quite complex, so it should be described.\
1. Firstly when I want to add a cell to 'possibleMoves' I check if cell 'to' is null
2. Then I create 2 variables containing original cell and figure standing on cell 'to'. Figure on 'to' could be null
3. Then I switch original cell to 'to'
4. Then I recalculate moves of all other figures on the board. Here I have kinda problem. \
I need 2 methods for calculating moves. First method is that I describe now and another shouldn't call recursive recalculating moves of other figures on the board. \
Here I use method 'calculatePotentialAttacks' that just watch where figure can move, without checking king danger.
5. I calculate potential attacks for each figure on board and check if any of them have king in potential attacks. \
If yes this move can't be performed. If no I add this cell to 'possibleMoves'
