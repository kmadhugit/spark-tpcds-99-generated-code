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
/* 038 */     UTF8String value2 = i.getUTF8String(0);
/* 039 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 040 */     boolean isNull3 = i.isNullAt(1);
/* 041 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 042 */     if (!isNull3) {
/* 043 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 044 */     }
/* 045 */
/* 046 */     boolean isNull4 = i.isNullAt(2);
/* 047 */     Decimal value4 = isNull4 ? null : (i.getDecimal(2, 35, 20));
/* 048 */     if (!isNull4) {
/* 049 */
/* 050 */       final byte[] bytes = value4.toJavaBigDecimal().unscaledValue().toByteArray();
/* 051 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bytes, Platform.BYTE_ARRAY_OFFSET, bytes.length, value1);
/* 052 */
/* 053 */     }
/* 054 */
/* 055 */     boolean isNull5 = i.isNullAt(3);
/* 056 */     int value5 = isNull5 ? -1 : (i.getInt(3));
/* 057 */     if (!isNull5) {
/* 058 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 059 */     }
/* 060 */
/* 061 */     boolean isNull6 = i.isNullAt(4);
/* 062 */     int value6 = isNull6 ? -1 : (i.getInt(4));
/* 063 */     if (!isNull6) {
/* 064 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 065 */     }
/* 066 */
/* 067 */     int value = -1;
/* 068 */
/* 069 */     int remainder = value1 % 64;
/* 070 */     if (remainder < 0) {
/* 071 */       value = (remainder + 64) % 64;
/* 072 */     } else {
/* 073 */       value = remainder;
/* 074 */     }
/* 075 */     rowWriter.write(0, value);
/* 076 */     return result;
/* 077 */   }
/* 078 */ }
