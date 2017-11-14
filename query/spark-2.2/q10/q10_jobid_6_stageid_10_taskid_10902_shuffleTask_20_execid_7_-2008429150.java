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
/* 014 */     result = new UnsafeRow(20);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 288);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 20);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull17 = i.isNullAt(17);
/* 029 */     UTF8String value17 = isNull17 ? null : (i.getUTF8String(17));
/* 030 */     if (isNull17) {
/* 031 */       rowWriter.setNullAt(17);
/* 032 */     } else {
/* 033 */       rowWriter.write(17, value17);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean value18 = i.getBoolean(18);
/* 038 */     rowWriter.write(18, value18);
/* 039 */
/* 040 */
/* 041 */     boolean value19 = i.getBoolean(19);
/* 042 */     rowWriter.write(19, value19);
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */
/* 047 */   private void apply_1(InternalRow i) {
/* 048 */
/* 049 */
/* 050 */     boolean isNull5 = i.isNullAt(5);
/* 051 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 052 */     if (isNull5) {
/* 053 */       rowWriter.setNullAt(5);
/* 054 */     } else {
/* 055 */       rowWriter.write(5, value5);
/* 056 */     }
/* 057 */
/* 058 */
/* 059 */     boolean isNull6 = i.isNullAt(6);
/* 060 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 061 */     if (isNull6) {
/* 062 */       rowWriter.setNullAt(6);
/* 063 */     } else {
/* 064 */       rowWriter.write(6, value6);
/* 065 */     }
/* 066 */
/* 067 */
/* 068 */     boolean isNull7 = i.isNullAt(7);
/* 069 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 070 */     if (isNull7) {
/* 071 */       rowWriter.setNullAt(7);
/* 072 */     } else {
/* 073 */       rowWriter.write(7, value7);
/* 074 */     }
/* 075 */
/* 076 */
/* 077 */     boolean isNull8 = i.isNullAt(8);
/* 078 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 079 */     if (isNull8) {
/* 080 */       rowWriter.setNullAt(8);
/* 081 */     } else {
/* 082 */       rowWriter.write(8, value8);
/* 083 */     }
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */
/* 088 */   private void apply_3(InternalRow i) {
/* 089 */
/* 090 */
/* 091 */     boolean isNull13 = i.isNullAt(13);
/* 092 */     int value13 = isNull13 ? -1 : (i.getInt(13));
/* 093 */     if (isNull13) {
/* 094 */       rowWriter.setNullAt(13);
/* 095 */     } else {
/* 096 */       rowWriter.write(13, value13);
/* 097 */     }
/* 098 */
/* 099 */
/* 100 */     boolean isNull14 = i.isNullAt(14);
/* 101 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 102 */     if (isNull14) {
/* 103 */       rowWriter.setNullAt(14);
/* 104 */     } else {
/* 105 */       rowWriter.write(14, value14);
/* 106 */     }
/* 107 */
/* 108 */
/* 109 */     boolean isNull15 = i.isNullAt(15);
/* 110 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(15));
/* 111 */     if (isNull15) {
/* 112 */       rowWriter.setNullAt(15);
/* 113 */     } else {
/* 114 */       rowWriter.write(15, value15);
/* 115 */     }
/* 116 */
/* 117 */
/* 118 */     boolean isNull16 = i.isNullAt(16);
/* 119 */     UTF8String value16 = isNull16 ? null : (i.getUTF8String(16));
/* 120 */     if (isNull16) {
/* 121 */       rowWriter.setNullAt(16);
/* 122 */     } else {
/* 123 */       rowWriter.write(16, value16);
/* 124 */     }
/* 125 */
/* 126 */   }
/* 127 */
/* 128 */
/* 129 */   private void apply_0(InternalRow i) {
/* 130 */
/* 131 */
/* 132 */     boolean isNull = i.isNullAt(0);
/* 133 */     int value = isNull ? -1 : (i.getInt(0));
/* 134 */     if (isNull) {
/* 135 */       rowWriter.setNullAt(0);
/* 136 */     } else {
/* 137 */       rowWriter.write(0, value);
/* 138 */     }
/* 139 */
/* 140 */
/* 141 */     boolean isNull1 = i.isNullAt(1);
/* 142 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 143 */     if (isNull1) {
/* 144 */       rowWriter.setNullAt(1);
/* 145 */     } else {
/* 146 */       rowWriter.write(1, value1);
/* 147 */     }
/* 148 */
/* 149 */
/* 150 */     boolean isNull2 = i.isNullAt(2);
/* 151 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 152 */     if (isNull2) {
/* 153 */       rowWriter.setNullAt(2);
/* 154 */     } else {
/* 155 */       rowWriter.write(2, value2);
/* 156 */     }
/* 157 */
/* 158 */
/* 159 */     boolean isNull3 = i.isNullAt(3);
/* 160 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 161 */     if (isNull3) {
/* 162 */       rowWriter.setNullAt(3);
/* 163 */     } else {
/* 164 */       rowWriter.write(3, value3);
/* 165 */     }
/* 166 */
/* 167 */
/* 168 */     boolean isNull4 = i.isNullAt(4);
/* 169 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 170 */     if (isNull4) {
/* 171 */       rowWriter.setNullAt(4);
/* 172 */     } else {
/* 173 */       rowWriter.write(4, value4);
/* 174 */     }
/* 175 */
/* 176 */   }
/* 177 */
/* 178 */
/* 179 */   private void apply_2(InternalRow i) {
/* 180 */
/* 181 */
/* 182 */     boolean isNull9 = i.isNullAt(9);
/* 183 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 184 */     if (isNull9) {
/* 185 */       rowWriter.setNullAt(9);
/* 186 */     } else {
/* 187 */       rowWriter.write(9, value9);
/* 188 */     }
/* 189 */
/* 190 */
/* 191 */     boolean isNull10 = i.isNullAt(10);
/* 192 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 193 */     if (isNull10) {
/* 194 */       rowWriter.setNullAt(10);
/* 195 */     } else {
/* 196 */       rowWriter.write(10, value10);
/* 197 */     }
/* 198 */
/* 199 */
/* 200 */     boolean isNull11 = i.isNullAt(11);
/* 201 */     int value11 = isNull11 ? -1 : (i.getInt(11));
/* 202 */     if (isNull11) {
/* 203 */       rowWriter.setNullAt(11);
/* 204 */     } else {
/* 205 */       rowWriter.write(11, value11);
/* 206 */     }
/* 207 */
/* 208 */
/* 209 */     boolean isNull12 = i.isNullAt(12);
/* 210 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 211 */     if (isNull12) {
/* 212 */       rowWriter.setNullAt(12);
/* 213 */     } else {
/* 214 */       rowWriter.write(12, value12);
/* 215 */     }
/* 216 */
/* 217 */   }
/* 218 */
/* 219 */
/* 220 */   // Scala.Function1 need this
/* 221 */   public java.lang.Object apply(java.lang.Object row) {
/* 222 */     return apply((InternalRow) row);
/* 223 */   }
/* 224 */
/* 225 */   public UnsafeRow apply(InternalRow i) {
/* 226 */     holder.reset();
/* 227 */
/* 228 */     rowWriter.zeroOutNullBytes();
/* 229 */     apply_0(i);
/* 230 */     apply_1(i);
/* 231 */     apply_2(i);
/* 232 */     apply_3(i);
/* 233 */     apply_4(i);
/* 234 */     result.setTotalSize(holder.totalSize());
/* 235 */     return result;
/* 236 */   }
/* 237 */ }
