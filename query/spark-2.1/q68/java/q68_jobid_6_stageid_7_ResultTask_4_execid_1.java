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
/* 014 */     result = new UnsafeRow(8);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 8);
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
/* 028 */     final double value6 = -1.0;
/* 029 */     if (true) {
/* 030 */       rowWriter.setNullAt(6);
/* 031 */     } else {
/* 032 */       rowWriter.write(6, value6);
/* 033 */     }
/* 034 */
/* 035 */
/* 036 */     final double value7 = -1.0;
/* 037 */     if (true) {
/* 038 */       rowWriter.setNullAt(7);
/* 039 */     } else {
/* 040 */       rowWriter.write(7, value7);
/* 041 */     }
/* 042 */
/* 043 */   }
/* 044 */
/* 045 */
/* 046 */   private void apply_0(InternalRow i) {
/* 047 */
/* 048 */
/* 049 */     final double value = -1.0;
/* 050 */     if (true) {
/* 051 */       rowWriter.setNullAt(0);
/* 052 */     } else {
/* 053 */       rowWriter.write(0, value);
/* 054 */     }
/* 055 */
/* 056 */
/* 057 */     final double value1 = -1.0;
/* 058 */     if (true) {
/* 059 */       rowWriter.setNullAt(1);
/* 060 */     } else {
/* 061 */       rowWriter.write(1, value1);
/* 062 */     }
/* 063 */
/* 064 */
/* 065 */     final double value2 = -1.0;
/* 066 */     if (true) {
/* 067 */       rowWriter.setNullAt(2);
/* 068 */     } else {
/* 069 */       rowWriter.write(2, value2);
/* 070 */     }
/* 071 */
/* 072 */
/* 073 */     final double value3 = -1.0;
/* 074 */     if (true) {
/* 075 */       rowWriter.setNullAt(3);
/* 076 */     } else {
/* 077 */       rowWriter.write(3, value3);
/* 078 */     }
/* 079 */
/* 080 */
/* 081 */     final double value4 = -1.0;
/* 082 */     if (true) {
/* 083 */       rowWriter.setNullAt(4);
/* 084 */     } else {
/* 085 */       rowWriter.write(4, value4);
/* 086 */     }
/* 087 */
/* 088 */
/* 089 */     final double value5 = -1.0;
/* 090 */     if (true) {
/* 091 */       rowWriter.setNullAt(5);
/* 092 */     } else {
/* 093 */       rowWriter.write(5, value5);
/* 094 */     }
/* 095 */
/* 096 */   }
/* 097 */
/* 098 */
/* 099 */   // Scala.Function1 need this
/* 100 */   public java.lang.Object apply(java.lang.Object row) {
/* 101 */     return apply((InternalRow) row);
/* 102 */   }
/* 103 */
/* 104 */   public UnsafeRow apply(InternalRow i) {
/* 105 */     rowWriter.zeroOutNullBytes();
/* 106 */     apply_0(i);
/* 107 */     apply_1(i);
/* 108 */     return result;
/* 109 */   }
/* 110 */ }
