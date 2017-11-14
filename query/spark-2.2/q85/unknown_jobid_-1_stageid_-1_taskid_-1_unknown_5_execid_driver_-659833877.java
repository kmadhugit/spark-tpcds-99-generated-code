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
/* 014 */     result = new UnsafeRow(3);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 64);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 3);
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
/* 032 */     holder.reset();
/* 033 */
/* 034 */     rowWriter.zeroOutNullBytes();
/* 035 */
/* 036 */
/* 037 */     boolean isNull1 = i.isNullAt(0);
/* 038 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 039 */     boolean isNull = isNull1;
/* 040 */     long value = -1L;
/* 041 */     if (!isNull1) {
/* 042 */       value = (long) value1;
/* 043 */     }
/* 044 */     if (isNull) {
/* 045 */       rowWriter.setNullAt(0);
/* 046 */     } else {
/* 047 */       rowWriter.write(0, value);
/* 048 */     }
/* 049 */
/* 050 */
/* 051 */     boolean isNull2 = i.isNullAt(1);
/* 052 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 053 */     if (isNull2) {
/* 054 */       rowWriter.setNullAt(1);
/* 055 */     } else {
/* 056 */       rowWriter.write(1, value2);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     boolean isNull3 = i.isNullAt(2);
/* 061 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(2));
/* 062 */     if (isNull3) {
/* 063 */       rowWriter.setNullAt(2);
/* 064 */     } else {
/* 065 */       rowWriter.write(2, value3);
/* 066 */     }
/* 067 */     result.setTotalSize(holder.totalSize());
/* 068 */     return result;
/* 069 */   }
/* 070 */ }
