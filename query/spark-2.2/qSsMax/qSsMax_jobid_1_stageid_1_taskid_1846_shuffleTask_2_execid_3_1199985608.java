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
/* 014 */     result = new UnsafeRow(11);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 11);
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
/* 028 */     final int value7 = -1;
/* 029 */     if (true) {
/* 030 */       rowWriter.setNullAt(7);
/* 031 */     } else {
/* 032 */       rowWriter.write(7, value7);
/* 033 */     }
/* 034 */
/* 035 */
/* 036 */     final int value8 = -1;
/* 037 */     if (true) {
/* 038 */       rowWriter.setNullAt(8);
/* 039 */     } else {
/* 040 */       rowWriter.write(8, value8);
/* 041 */     }
/* 042 */
/* 043 */
/* 044 */     final int value9 = -1;
/* 045 */     if (true) {
/* 046 */       rowWriter.setNullAt(9);
/* 047 */     } else {
/* 048 */       rowWriter.write(9, value9);
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     final int value10 = -1;
/* 053 */     if (true) {
/* 054 */       rowWriter.setNullAt(10);
/* 055 */     } else {
/* 056 */       rowWriter.write(10, value10);
/* 057 */     }
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */
/* 062 */   private void apply_0(InternalRow i) {
/* 063 */
/* 064 */
/* 065 */     rowWriter.write(0, 0L);
/* 066 */
/* 067 */
/* 068 */     rowWriter.write(1, 0L);
/* 069 */
/* 070 */
/* 071 */     final int value2 = -1;
/* 072 */     if (true) {
/* 073 */       rowWriter.setNullAt(2);
/* 074 */     } else {
/* 075 */       rowWriter.write(2, value2);
/* 076 */     }
/* 077 */
/* 078 */
/* 079 */     final int value3 = -1;
/* 080 */     if (true) {
/* 081 */       rowWriter.setNullAt(3);
/* 082 */     } else {
/* 083 */       rowWriter.write(3, value3);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     final int value4 = -1;
/* 088 */     if (true) {
/* 089 */       rowWriter.setNullAt(4);
/* 090 */     } else {
/* 091 */       rowWriter.write(4, value4);
/* 092 */     }
/* 093 */
/* 094 */
/* 095 */     final int value5 = -1;
/* 096 */     if (true) {
/* 097 */       rowWriter.setNullAt(5);
/* 098 */     } else {
/* 099 */       rowWriter.write(5, value5);
/* 100 */     }
/* 101 */
/* 102 */
/* 103 */     final int value6 = -1;
/* 104 */     if (true) {
/* 105 */       rowWriter.setNullAt(6);
/* 106 */     } else {
/* 107 */       rowWriter.write(6, value6);
/* 108 */     }
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */
/* 113 */   // Scala.Function1 need this
/* 114 */   public java.lang.Object apply(java.lang.Object row) {
/* 115 */     return apply((InternalRow) row);
/* 116 */   }
/* 117 */
/* 118 */   public UnsafeRow apply(InternalRow i) {
/* 119 */     rowWriter.zeroOutNullBytes();
/* 120 */     apply_0(i);
/* 121 */     apply_1(i);
/* 122 */     return result;
/* 123 */   }
/* 124 */ }
