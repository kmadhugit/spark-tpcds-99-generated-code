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
/* 051 */     boolean isNull2 = false;
/* 052 */     double value2 = -1.0;
/* 053 */     if (!false) {
/* 054 */       value2 = (double) 0;
/* 055 */     }
/* 056 */     if (isNull2) {
/* 057 */       rowWriter.setNullAt(2);
/* 058 */     } else {
/* 059 */       rowWriter.write(2, value2);
/* 060 */     }
/* 061 */
/* 062 */
/* 063 */     rowWriter.write(3, 0L);
/* 064 */
/* 065 */
/* 066 */     rowWriter.write(4, 0.0D);
/* 067 */
/* 068 */
/* 069 */     rowWriter.write(5, 0.0D);
/* 070 */
/* 071 */
/* 072 */     rowWriter.write(6, 0.0D);
/* 073 */
/* 074 */
/* 075 */     rowWriter.write(7, 0L);
/* 076 */     return result;
/* 077 */   }
/* 078 */ }
