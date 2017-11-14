/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */
/* 028 */   // Scala.Function1 need this
/* 029 */   public java.lang.Object apply(java.lang.Object row) {
/* 030 */     return apply((InternalRow) row);
/* 031 */   }
/* 032 */
/* 033 */   public UnsafeRow apply(InternalRow i) {
/* 034 */     boolean isNull = false;
/* 035 */
/* 036 */     value1 = 42;
/* 037 */
/* 038 */     byte value2 = i.getByte(4);
/* 039 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value2, value1);
/* 040 */     boolean isNull3 = i.isNullAt(5);
/* 041 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(5));
/* 042 */     if (!isNull3) {
/* 043 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 044 */     }
/* 045 */
/* 046 */     int value = -1;
/* 047 */
/* 048 */     int remainder = value1 % 64;
/* 049 */     if (remainder < 0) {
/* 050 */       value = (remainder + 64) % 64;
/* 051 */     } else {
/* 052 */       value = remainder;
/* 053 */     }
/* 054 */     rowWriter.write(0, value);
/* 055 */     return result;
/* 056 */   }
/* 057 */ }
