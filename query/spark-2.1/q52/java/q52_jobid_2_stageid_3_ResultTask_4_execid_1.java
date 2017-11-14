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
/* 014 */     result = new UnsafeRow(5);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 5);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   // Scala.Function1 need this
/* 027 */   public java.lang.Object apply(java.lang.Object row) {
/* 028 */     return apply((InternalRow) row);
/* 029 */   }
/* 030 */
/* 031 */   public UnsafeRow apply(InternalRow i) {
/* 032 */     rowWriter.zeroOutNullBytes();
/* 033 */
/* 034 */
/* 035 */     final double value = -1.0;
/* 036 */     if (true) {
/* 037 */       rowWriter.setNullAt(0);
/* 038 */     } else {
/* 039 */       rowWriter.write(0, value);
/* 040 */     }
/* 041 */
/* 042 */
/* 043 */     final double value1 = -1.0;
/* 044 */     if (true) {
/* 045 */       rowWriter.setNullAt(1);
/* 046 */     } else {
/* 047 */       rowWriter.write(1, value1);
/* 048 */     }
/* 049 */
/* 050 */
/* 051 */     final double value2 = -1.0;
/* 052 */     if (true) {
/* 053 */       rowWriter.setNullAt(2);
/* 054 */     } else {
/* 055 */       rowWriter.write(2, value2);
/* 056 */     }
/* 057 */
/* 058 */
/* 059 */     final double value3 = -1.0;
/* 060 */     if (true) {
/* 061 */       rowWriter.setNullAt(3);
/* 062 */     } else {
/* 063 */       rowWriter.write(3, value3);
/* 064 */     }
/* 065 */
/* 066 */
/* 067 */     final double value4 = -1.0;
/* 068 */     if (true) {
/* 069 */       rowWriter.setNullAt(4);
/* 070 */     } else {
/* 071 */       rowWriter.write(4, value4);
/* 072 */     }
/* 073 */     return result;
/* 074 */   }
/* 075 */ }
