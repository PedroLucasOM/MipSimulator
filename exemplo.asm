addi $t0,$t0,10
label: addi $s3,$s3,2
sw $s3,0($s3)
add $s0,$s3,$s0
lw $s7,0($s0)
beq $s3,$t0,final
j label
final: