/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(15);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 15);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull9 = false;
/* 029 */     double value9 = -1.0;
/* 030 */     if (!false) {
/* 031 */       value9 = (double) 0;
/* 032 */     }
/* 033 */     if (isNull9) {
/* 034 */       rowWriter.setNullAt(8);
/* 035 */     } else {
/* 036 */       rowWriter.write(8, value9);
/* 037 */     }
/* 038 */
/* 039 */
/* 040 */     rowWriter.write(9, 0L);
/* 041 */
/* 042 */
/* 043 */     rowWriter.write(10, 0L);
/* 044 */
/* 045 */
/* 046 */     final int value13 = -1;
/* 047 */     if (true) {
/* 048 */       rowWriter.setNullAt(11);
/* 049 */     } else {
/* 050 */       rowWriter.write(11, value13);
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     final int value14 = -1;
/* 055 */     if (true) {
/* 056 */       rowWriter.setNullAt(12);
/* 057 */     } else {
/* 058 */       rowWriter.write(12, value14);
/* 059 */     }
/* 060 */
/* 061 */
/* 062 */     boolean isNull15 = false;
/* 063 */     double value15 = -1.0;
/* 064 */     if (!false) {
/* 065 */       value15 = (double) 0;
/* 066 */     }
/* 067 */     if (isNull15) {
/* 068 */       rowWriter.setNullAt(13);
/* 069 */     } else {
/* 070 */       rowWriter.write(13, value15);
/* 071 */     }
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */
/* 076 */   private void apply_0(InternalRow i) {
/* 077 */
/* 078 */
/* 079 */     rowWriter.write(0, 0L);
/* 080 */
/* 081 */
/* 082 */     final int value1 = -1;
/* 083 */     if (true) {
/* 084 */       rowWriter.setNullAt(1);
/* 085 */     } else {
/* 086 */       rowWriter.write(1, value1);
/* 087 */     }
/* 088 */
/* 089 */
/* 090 */     final int value2 = -1;
/* 091 */     if (true) {
/* 092 */       rowWriter.setNullAt(2);
/* 093 */     } else {
/* 094 */       rowWriter.write(2, value2);
/* 095 */     }
/* 096 */
/* 097 */
/* 098 */     boolean isNull3 = false;
/* 099 */     double value3 = -1.0;
/* 100 */     if (!false) {
/* 101 */       value3 = (double) 0;
/* 102 */     }
/* 103 */     if (isNull3) {
/* 104 */       rowWriter.setNullAt(3);
/* 105 */     } else {
/* 106 */       rowWriter.write(3, value3);
/* 107 */     }
/* 108 */
/* 109 */
/* 110 */     rowWriter.write(4, 0L);
/* 111 */
/* 112 */
/* 113 */     rowWriter.write(5, 0L);
/* 114 */
/* 115 */
/* 116 */     final int value7 = -1;
/* 117 */     if (true) {
/* 118 */       rowWriter.setNullAt(6);
/* 119 */     } else {
/* 120 */       rowWriter.write(6, value7);
/* 121 */     }
/* 122 */
/* 123 */
/* 124 */     final int value8 = -1;
/* 125 */     if (true) {
/* 126 */       rowWriter.setNullAt(7);
/* 127 */     } else {
/* 128 */       rowWriter.write(7, value8);
/* 129 */     }
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */
/* 134 */   private void apply_2(InternalRow i) {
/* 135 */
/* 136 */
/* 137 */     rowWriter.write(14, 0L);
/* 138 */
/* 139 */   }
/* 140 */
/* 141 */
/* 142 */   // Scala.Function1 need this
/* 143 */   public java.lang.Object apply(java.lang.Object row) {
/* 144 */     return apply((InternalRow) row);
/* 145 */   }
/* 146 */
/* 147 */   public UnsafeRow apply(InternalRow i) {
/* 148 */     rowWriter.zeroOutNullBytes();
/* 149 */     apply_0(i);
/* 150 */     apply_1(i);
/* 151 */     apply_2(i);
/* 152 */     return result;
/* 153 */   }
/* 154 */ }
