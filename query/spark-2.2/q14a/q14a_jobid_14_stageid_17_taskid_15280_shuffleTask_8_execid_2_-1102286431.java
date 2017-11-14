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
/* 038 */     boolean isNull3 = i.isNullAt(0);
/* 039 */     int value3 = isNull3 ? -1 : (i.getInt(0));
/* 040 */     boolean isNull2 = isNull3;
/* 041 */     int value2 = value3;
/* 042 */     if (isNull2) {
/* 043 */
/* 044 */       if (!false) {
/* 045 */         isNull2 = false;
/* 046 */         value2 = 0;
/* 047 */       }
/* 048 */     }
/* 049 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value2, value1);
/* 050 */     boolean isNull6 = i.isNullAt(1);
/* 051 */     int value6 = isNull6 ? -1 : (i.getInt(1));
/* 052 */     boolean isNull5 = isNull6;
/* 053 */     int value5 = value6;
/* 054 */     if (isNull5) {
/* 055 */
/* 056 */       if (!false) {
/* 057 */         isNull5 = false;
/* 058 */         value5 = 0;
/* 059 */       }
/* 060 */     }
/* 061 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 062 */     boolean isNull9 = i.isNullAt(2);
/* 063 */     int value9 = isNull9 ? -1 : (i.getInt(2));
/* 064 */     boolean isNull8 = isNull9;
/* 065 */     int value8 = value9;
/* 066 */     if (isNull8) {
/* 067 */
/* 068 */       if (!false) {
/* 069 */         isNull8 = false;
/* 070 */         value8 = 0;
/* 071 */       }
/* 072 */     }
/* 073 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value8, value1);
/* 074 */
/* 075 */     int value = -1;
/* 076 */
/* 077 */     int remainder = value1 % 64;
/* 078 */     if (remainder < 0) {
/* 079 */       value = (remainder + 64) % 64;
/* 080 */     } else {
/* 081 */       value = remainder;
/* 082 */     }
/* 083 */     rowWriter.write(0, value);
/* 084 */     return result;
/* 085 */   }
/* 086 */ }
