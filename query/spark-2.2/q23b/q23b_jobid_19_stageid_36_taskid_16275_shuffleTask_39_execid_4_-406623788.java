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
/* 014 */     result = new UnsafeRow(18);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 288);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 18);
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
/* 036 */   }
/* 037 */
/* 038 */
/* 039 */   private void apply_1(InternalRow i) {
/* 040 */
/* 041 */
/* 042 */     boolean isNull5 = i.isNullAt(5);
/* 043 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 044 */     if (isNull5) {
/* 045 */       rowWriter.setNullAt(5);
/* 046 */     } else {
/* 047 */       rowWriter.write(5, value5);
/* 048 */     }
/* 049 */
/* 050 */
/* 051 */     boolean isNull6 = i.isNullAt(6);
/* 052 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 053 */     if (isNull6) {
/* 054 */       rowWriter.setNullAt(6);
/* 055 */     } else {
/* 056 */       rowWriter.write(6, value6);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     boolean isNull7 = i.isNullAt(7);
/* 061 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 062 */     if (isNull7) {
/* 063 */       rowWriter.setNullAt(7);
/* 064 */     } else {
/* 065 */       rowWriter.write(7, value7);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull8 = i.isNullAt(8);
/* 070 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 071 */     if (isNull8) {
/* 072 */       rowWriter.setNullAt(8);
/* 073 */     } else {
/* 074 */       rowWriter.write(8, value8);
/* 075 */     }
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */
/* 080 */   private void apply_3(InternalRow i) {
/* 081 */
/* 082 */
/* 083 */     boolean isNull13 = i.isNullAt(13);
/* 084 */     int value13 = isNull13 ? -1 : (i.getInt(13));
/* 085 */     if (isNull13) {
/* 086 */       rowWriter.setNullAt(13);
/* 087 */     } else {
/* 088 */       rowWriter.write(13, value13);
/* 089 */     }
/* 090 */
/* 091 */
/* 092 */     boolean isNull14 = i.isNullAt(14);
/* 093 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 094 */     if (isNull14) {
/* 095 */       rowWriter.setNullAt(14);
/* 096 */     } else {
/* 097 */       rowWriter.write(14, value14);
/* 098 */     }
/* 099 */
/* 100 */
/* 101 */     boolean isNull15 = i.isNullAt(15);
/* 102 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(15));
/* 103 */     if (isNull15) {
/* 104 */       rowWriter.setNullAt(15);
/* 105 */     } else {
/* 106 */       rowWriter.write(15, value15);
/* 107 */     }
/* 108 */
/* 109 */
/* 110 */     boolean isNull16 = i.isNullAt(16);
/* 111 */     UTF8String value16 = isNull16 ? null : (i.getUTF8String(16));
/* 112 */     if (isNull16) {
/* 113 */       rowWriter.setNullAt(16);
/* 114 */     } else {
/* 115 */       rowWriter.write(16, value16);
/* 116 */     }
/* 117 */
/* 118 */   }
/* 119 */
/* 120 */
/* 121 */   private void apply_0(InternalRow i) {
/* 122 */
/* 123 */
/* 124 */     boolean isNull = i.isNullAt(0);
/* 125 */     int value = isNull ? -1 : (i.getInt(0));
/* 126 */     if (isNull) {
/* 127 */       rowWriter.setNullAt(0);
/* 128 */     } else {
/* 129 */       rowWriter.write(0, value);
/* 130 */     }
/* 131 */
/* 132 */
/* 133 */     boolean isNull1 = i.isNullAt(1);
/* 134 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 135 */     if (isNull1) {
/* 136 */       rowWriter.setNullAt(1);
/* 137 */     } else {
/* 138 */       rowWriter.write(1, value1);
/* 139 */     }
/* 140 */
/* 141 */
/* 142 */     boolean isNull2 = i.isNullAt(2);
/* 143 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 144 */     if (isNull2) {
/* 145 */       rowWriter.setNullAt(2);
/* 146 */     } else {
/* 147 */       rowWriter.write(2, value2);
/* 148 */     }
/* 149 */
/* 150 */
/* 151 */     boolean isNull3 = i.isNullAt(3);
/* 152 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 153 */     if (isNull3) {
/* 154 */       rowWriter.setNullAt(3);
/* 155 */     } else {
/* 156 */       rowWriter.write(3, value3);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull4 = i.isNullAt(4);
/* 161 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 162 */     if (isNull4) {
/* 163 */       rowWriter.setNullAt(4);
/* 164 */     } else {
/* 165 */       rowWriter.write(4, value4);
/* 166 */     }
/* 167 */
/* 168 */   }
/* 169 */
/* 170 */
/* 171 */   private void apply_2(InternalRow i) {
/* 172 */
/* 173 */
/* 174 */     boolean isNull9 = i.isNullAt(9);
/* 175 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 176 */     if (isNull9) {
/* 177 */       rowWriter.setNullAt(9);
/* 178 */     } else {
/* 179 */       rowWriter.write(9, value9);
/* 180 */     }
/* 181 */
/* 182 */
/* 183 */     boolean isNull10 = i.isNullAt(10);
/* 184 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 185 */     if (isNull10) {
/* 186 */       rowWriter.setNullAt(10);
/* 187 */     } else {
/* 188 */       rowWriter.write(10, value10);
/* 189 */     }
/* 190 */
/* 191 */
/* 192 */     boolean isNull11 = i.isNullAt(11);
/* 193 */     int value11 = isNull11 ? -1 : (i.getInt(11));
/* 194 */     if (isNull11) {
/* 195 */       rowWriter.setNullAt(11);
/* 196 */     } else {
/* 197 */       rowWriter.write(11, value11);
/* 198 */     }
/* 199 */
/* 200 */
/* 201 */     boolean isNull12 = i.isNullAt(12);
/* 202 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 203 */     if (isNull12) {
/* 204 */       rowWriter.setNullAt(12);
/* 205 */     } else {
/* 206 */       rowWriter.write(12, value12);
/* 207 */     }
/* 208 */
/* 209 */   }
/* 210 */
/* 211 */
/* 212 */   // Scala.Function1 need this
/* 213 */   public java.lang.Object apply(java.lang.Object row) {
/* 214 */     return apply((InternalRow) row);
/* 215 */   }
/* 216 */
/* 217 */   public UnsafeRow apply(InternalRow i) {
/* 218 */     holder.reset();
/* 219 */
/* 220 */     rowWriter.zeroOutNullBytes();
/* 221 */     apply_0(i);
/* 222 */     apply_1(i);
/* 223 */     apply_2(i);
/* 224 */     apply_3(i);
/* 225 */     apply_4(i);
/* 226 */     result.setTotalSize(holder.totalSize());
/* 227 */     return result;
/* 228 */   }
/* 229 */ }
