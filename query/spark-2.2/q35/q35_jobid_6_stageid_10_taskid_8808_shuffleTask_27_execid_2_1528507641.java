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
/* 028 */     boolean isNull5 = i.isNullAt(5);
/* 029 */     long value5 = isNull5 ? -1L : (i.getLong(5));
/* 030 */     if (isNull5) {
/* 031 */       rowWriter.setNullAt(5);
/* 032 */     } else {
/* 033 */       rowWriter.write(5, value5);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull6 = i.isNullAt(6);
/* 038 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 039 */     if (isNull6) {
/* 040 */       rowWriter.setNullAt(6);
/* 041 */     } else {
/* 042 */       rowWriter.write(6, value6);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull7 = i.isNullAt(7);
/* 047 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 048 */     if (isNull7) {
/* 049 */       rowWriter.setNullAt(7);
/* 050 */     } else {
/* 051 */       rowWriter.write(7, value7);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull8 = i.isNullAt(8);
/* 056 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 057 */     if (isNull8) {
/* 058 */       rowWriter.setNullAt(8);
/* 059 */     } else {
/* 060 */       rowWriter.write(8, value8);
/* 061 */     }
/* 062 */
/* 063 */
/* 064 */     boolean isNull9 = i.isNullAt(9);
/* 065 */     long value9 = isNull9 ? -1L : (i.getLong(9));
/* 066 */     if (isNull9) {
/* 067 */       rowWriter.setNullAt(9);
/* 068 */     } else {
/* 069 */       rowWriter.write(9, value9);
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_3(InternalRow i) {
/* 076 */
/* 077 */
/* 078 */     boolean isNull14 = i.isNullAt(14);
/* 079 */     long value14 = isNull14 ? -1L : (i.getLong(14));
/* 080 */     if (isNull14) {
/* 081 */       rowWriter.setNullAt(14);
/* 082 */     } else {
/* 083 */       rowWriter.write(14, value14);
/* 084 */     }
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */
/* 089 */   private void apply_0(InternalRow i) {
/* 090 */
/* 091 */
/* 092 */     boolean isNull = i.isNullAt(0);
/* 093 */     long value = isNull ? -1L : (i.getLong(0));
/* 094 */     if (isNull) {
/* 095 */       rowWriter.setNullAt(0);
/* 096 */     } else {
/* 097 */       rowWriter.write(0, value);
/* 098 */     }
/* 099 */
/* 100 */
/* 101 */     boolean isNull1 = i.isNullAt(1);
/* 102 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 103 */     if (isNull1) {
/* 104 */       rowWriter.setNullAt(1);
/* 105 */     } else {
/* 106 */       rowWriter.write(1, value1);
/* 107 */     }
/* 108 */
/* 109 */
/* 110 */     boolean isNull2 = i.isNullAt(2);
/* 111 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 112 */     if (isNull2) {
/* 113 */       rowWriter.setNullAt(2);
/* 114 */     } else {
/* 115 */       rowWriter.write(2, value2);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull3 = i.isNullAt(3);
/* 120 */     double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 121 */     if (isNull3) {
/* 122 */       rowWriter.setNullAt(3);
/* 123 */     } else {
/* 124 */       rowWriter.write(3, value3);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull4 = i.isNullAt(4);
/* 129 */     long value4 = isNull4 ? -1L : (i.getLong(4));
/* 130 */     if (isNull4) {
/* 131 */       rowWriter.setNullAt(4);
/* 132 */     } else {
/* 133 */       rowWriter.write(4, value4);
/* 134 */     }
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */
/* 139 */   private void apply_2(InternalRow i) {
/* 140 */
/* 141 */
/* 142 */     boolean isNull10 = i.isNullAt(10);
/* 143 */     long value10 = isNull10 ? -1L : (i.getLong(10));
/* 144 */     if (isNull10) {
/* 145 */       rowWriter.setNullAt(10);
/* 146 */     } else {
/* 147 */       rowWriter.write(10, value10);
/* 148 */     }
/* 149 */
/* 150 */
/* 151 */     boolean isNull11 = i.isNullAt(11);
/* 152 */     int value11 = isNull11 ? -1 : (i.getInt(11));
/* 153 */     if (isNull11) {
/* 154 */       rowWriter.setNullAt(11);
/* 155 */     } else {
/* 156 */       rowWriter.write(11, value11);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull12 = i.isNullAt(12);
/* 161 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 162 */     if (isNull12) {
/* 163 */       rowWriter.setNullAt(12);
/* 164 */     } else {
/* 165 */       rowWriter.write(12, value12);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull13 = i.isNullAt(13);
/* 170 */     double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 171 */     if (isNull13) {
/* 172 */       rowWriter.setNullAt(13);
/* 173 */     } else {
/* 174 */       rowWriter.write(13, value13);
/* 175 */     }
/* 176 */
/* 177 */   }
/* 178 */
/* 179 */
/* 180 */   // Scala.Function1 need this
/* 181 */   public java.lang.Object apply(java.lang.Object row) {
/* 182 */     return apply((InternalRow) row);
/* 183 */   }
/* 184 */
/* 185 */   public UnsafeRow apply(InternalRow i) {
/* 186 */     rowWriter.zeroOutNullBytes();
/* 187 */     apply_0(i);
/* 188 */     apply_1(i);
/* 189 */     apply_2(i);
/* 190 */     apply_3(i);
/* 191 */     return result;
/* 192 */   }
/* 193 */ }
