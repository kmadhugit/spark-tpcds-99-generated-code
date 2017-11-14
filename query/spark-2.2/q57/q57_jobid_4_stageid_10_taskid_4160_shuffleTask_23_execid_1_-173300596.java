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
/* 038 */     boolean isNull2 = i.isNullAt(0);
/* 039 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 040 */     if (!isNull2) {
/* 041 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 042 */     }
/* 043 */
/* 044 */     boolean isNull3 = i.isNullAt(1);
/* 045 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 046 */     if (!isNull3) {
/* 047 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 048 */     }
/* 049 */
/* 050 */     boolean isNull4 = i.isNullAt(2);
/* 051 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 052 */     if (!isNull4) {
/* 053 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 054 */     }
/* 055 */
/* 056 */     boolean isNull5 = true;
/* 057 */     int value5 = -1;
/* 058 */
/* 059 */     boolean isNull6 = i.isNullAt(4);
/* 060 */     int value6 = isNull6 ? -1 : (i.getInt(4));
/* 061 */     if (!isNull6) {
/* 062 */
/* 063 */
/* 064 */       isNull5 = false; // resultCode could change nullability.
/* 065 */       value5 = value6 - 1;
/* 066 */
/* 067 */     }
/* 068 */     if (!isNull5) {
/* 069 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 070 */     }
/* 071 */
/* 072 */     int value = -1;
/* 073 */
/* 074 */     int remainder = value1 % 64;
/* 075 */     if (remainder < 0) {
/* 076 */       value = (remainder + 64) % 64;
/* 077 */     } else {
/* 078 */       value = remainder;
/* 079 */     }
/* 080 */     rowWriter.write(0, value);
/* 081 */     return result;
/* 082 */   }
/* 083 */ }
