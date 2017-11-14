/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value10;
/* 013 */   private UTF8String smj_value11;
/* 014 */   private UTF8String smj_value12;
/* 015 */   private int smj_value13;
/* 016 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 017 */   private UTF8String smj_value14;
/* 018 */   private UTF8String smj_value15;
/* 019 */   private UTF8String smj_value16;
/* 020 */   private int smj_value17;
/* 021 */   private UTF8String smj_value18;
/* 022 */   private boolean smj_isNull10;
/* 023 */   private UTF8String smj_value19;
/* 024 */   private boolean smj_isNull11;
/* 025 */   private UTF8String smj_value20;
/* 026 */   private boolean smj_isNull12;
/* 027 */   private int smj_value21;
/* 028 */   private boolean smj_isNull13;
/* 029 */   private int smj_value22;
/* 030 */   private boolean smj_isNull14;
/* 031 */   private double smj_value23;
/* 032 */   private boolean smj_isNull15;
/* 033 */   private double smj_value24;
/* 034 */   private boolean smj_isNull16;
/* 035 */   private int smj_value25;
/* 036 */   private boolean smj_isNull17;
/* 037 */   private double smj_value26;
/* 038 */   private boolean smj_isNull18;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 040 */   private UnsafeRow smj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     smj_leftInput = inputs[0];
/* 055 */     smj_rightInput = inputs[1];
/* 056 */
/* 057 */     smj_rightRow = null;
/* 058 */
/* 059 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 060 */
/* 061 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 062 */     smj_result = new UnsafeRow(14);
/* 063 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 192);
/* 064 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 14);
/* 065 */     project_result = new UnsafeRow(9);
/* 066 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 067 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private boolean findNextInnerJoinRows(
/* 072 */     scala.collection.Iterator leftIter,
/* 073 */     scala.collection.Iterator rightIter) {
/* 074 */     smj_leftRow = null;
/* 075 */     int comp = 0;
/* 076 */     while (smj_leftRow == null) {
/* 077 */       if (!leftIter.hasNext()) return false;
/* 078 */       smj_leftRow = (InternalRow) leftIter.next();
/* 079 */
/* 080 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 081 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 082 */
/* 083 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 084 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(1));
/* 085 */
/* 086 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 087 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(2));
/* 088 */
/* 089 */       boolean smj_isNull3 = smj_leftRow.isNullAt(7);
/* 090 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(7));
/* 091 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || smj_isNull3) {
/* 092 */         smj_leftRow = null;
/* 093 */         continue;
/* 094 */       }
/* 095 */       if (!smj_matches.isEmpty()) {
/* 096 */         comp = 0;
/* 097 */         if (comp == 0) {
/* 098 */           comp = smj_value.compare(smj_value14);
/* 099 */         }
/* 100 */         if (comp == 0) {
/* 101 */           comp = smj_value1.compare(smj_value15);
/* 102 */         }
/* 103 */         if (comp == 0) {
/* 104 */           comp = smj_value2.compare(smj_value16);
/* 105 */         }
/* 106 */         if (comp == 0) {
/* 107 */           comp = (smj_value3 > smj_value17 ? 1 : smj_value3 < smj_value17 ? -1 : 0);
/* 108 */         }
/* 109 */
/* 110 */         if (comp == 0) {
/* 111 */           return true;
/* 112 */         }
/* 113 */         smj_matches.clear();
/* 114 */       }
/* 115 */
/* 116 */       do {
/* 117 */         if (smj_rightRow == null) {
/* 118 */           if (!rightIter.hasNext()) {
/* 119 */             smj_value14 = smj_value.clone();
/* 120 */             smj_value15 = smj_value1.clone();
/* 121 */             smj_value16 = smj_value2.clone();
/* 122 */             smj_value17 = smj_value3;
/* 123 */             return !smj_matches.isEmpty();
/* 124 */           }
/* 125 */           smj_rightRow = (InternalRow) rightIter.next();
/* 126 */
/* 127 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 128 */           UTF8String smj_value4 = smj_isNull4 ? null : (smj_rightRow.getUTF8String(0));
/* 129 */
/* 130 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 131 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(1));
/* 132 */
/* 133 */           boolean smj_isNull6 = smj_rightRow.isNullAt(2);
/* 134 */           UTF8String smj_value6 = smj_isNull6 ? null : (smj_rightRow.getUTF8String(2));
/* 135 */
/* 136 */           boolean smj_isNull7 = true;
/* 137 */           int smj_value7 = -1;
/* 138 */
/* 139 */           boolean smj_isNull8 = smj_rightRow.isNullAt(4);
/* 140 */           int smj_value8 = smj_isNull8 ? -1 : (smj_rightRow.getInt(4));
/* 141 */           if (!smj_isNull8) {
/* 142 */             smj_isNull7 = false; // resultCode could change nullability.
/* 143 */             smj_value7 = smj_value8 - 1;
/* 144 */
/* 145 */           }
/* 146 */           if (smj_isNull4 || smj_isNull5 || smj_isNull6 || smj_isNull7) {
/* 147 */             smj_rightRow = null;
/* 148 */             continue;
/* 149 */           }
/* 150 */           smj_value10 = smj_value4.clone();
/* 151 */           smj_value11 = smj_value5.clone();
/* 152 */           smj_value12 = smj_value6.clone();
/* 153 */           smj_value13 = smj_value7;
/* 154 */         }
/* 155 */
/* 156 */         comp = 0;
/* 157 */         if (comp == 0) {
/* 158 */           comp = smj_value.compare(smj_value10);
/* 159 */         }
/* 160 */         if (comp == 0) {
/* 161 */           comp = smj_value1.compare(smj_value11);
/* 162 */         }
/* 163 */         if (comp == 0) {
/* 164 */           comp = smj_value2.compare(smj_value12);
/* 165 */         }
/* 166 */         if (comp == 0) {
/* 167 */           comp = (smj_value3 > smj_value13 ? 1 : smj_value3 < smj_value13 ? -1 : 0);
/* 168 */         }
/* 169 */
/* 170 */         if (comp > 0) {
/* 171 */           smj_rightRow = null;
/* 172 */         } else if (comp < 0) {
/* 173 */           if (!smj_matches.isEmpty()) {
/* 174 */             smj_value14 = smj_value.clone();
/* 175 */             smj_value15 = smj_value1.clone();
/* 176 */             smj_value16 = smj_value2.clone();
/* 177 */             smj_value17 = smj_value3;
/* 178 */             return true;
/* 179 */           }
/* 180 */           smj_leftRow = null;
/* 181 */         } else {
/* 182 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 183 */           smj_rightRow = null;;
/* 184 */         }
/* 185 */       } while (smj_leftRow != null);
/* 186 */     }
/* 187 */     return false; // unreachable
/* 188 */   }
/* 189 */
/* 190 */   protected void processNext() throws java.io.IOException {
/* 191 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 192 */       smj_isNull10 = smj_leftRow.isNullAt(0);
/* 193 */       smj_value18 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(0));
/* 194 */       smj_isNull11 = smj_leftRow.isNullAt(1);
/* 195 */       smj_value19 = smj_isNull11 ? null : (smj_leftRow.getUTF8String(1));
/* 196 */       smj_isNull12 = smj_leftRow.isNullAt(2);
/* 197 */       smj_value20 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(2));
/* 198 */       smj_isNull13 = smj_leftRow.isNullAt(3);
/* 199 */       smj_value21 = smj_isNull13 ? -1 : (smj_leftRow.getInt(3));
/* 200 */       smj_isNull14 = smj_leftRow.isNullAt(4);
/* 201 */       smj_value22 = smj_isNull14 ? -1 : (smj_leftRow.getInt(4));
/* 202 */       smj_isNull15 = smj_leftRow.isNullAt(5);
/* 203 */       smj_value23 = smj_isNull15 ? -1.0 : (smj_leftRow.getDouble(5));
/* 204 */       smj_isNull16 = smj_leftRow.isNullAt(6);
/* 205 */       smj_value24 = smj_isNull16 ? -1.0 : (smj_leftRow.getDouble(6));
/* 206 */       smj_isNull17 = smj_leftRow.isNullAt(7);
/* 207 */       smj_value25 = smj_isNull17 ? -1 : (smj_leftRow.getInt(7));
/* 208 */       smj_isNull18 = smj_leftRow.isNullAt(8);
/* 209 */       smj_value26 = smj_isNull18 ? -1.0 : (smj_leftRow.getDouble(8));
/* 210 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 211 */       while (smj_iterator.hasNext()) {
/* 212 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 213 */
/* 214 */         smj_numOutputRows.add(1);
/* 215 */
/* 216 */         boolean smj_isNull22 = smj_rightRow1.isNullAt(3);
/* 217 */         double smj_value30 = smj_isNull22 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 218 */         project_holder.reset();
/* 219 */
/* 220 */         project_rowWriter.zeroOutNullBytes();
/* 221 */
/* 222 */         if (smj_isNull10) {
/* 223 */           project_rowWriter.setNullAt(0);
/* 224 */         } else {
/* 225 */           project_rowWriter.write(0, smj_value18);
/* 226 */         }
/* 227 */
/* 228 */         if (smj_isNull11) {
/* 229 */           project_rowWriter.setNullAt(1);
/* 230 */         } else {
/* 231 */           project_rowWriter.write(1, smj_value19);
/* 232 */         }
/* 233 */
/* 234 */         if (smj_isNull12) {
/* 235 */           project_rowWriter.setNullAt(2);
/* 236 */         } else {
/* 237 */           project_rowWriter.write(2, smj_value20);
/* 238 */         }
/* 239 */
/* 240 */         if (smj_isNull13) {
/* 241 */           project_rowWriter.setNullAt(3);
/* 242 */         } else {
/* 243 */           project_rowWriter.write(3, smj_value21);
/* 244 */         }
/* 245 */
/* 246 */         if (smj_isNull14) {
/* 247 */           project_rowWriter.setNullAt(4);
/* 248 */         } else {
/* 249 */           project_rowWriter.write(4, smj_value22);
/* 250 */         }
/* 251 */
/* 252 */         if (smj_isNull16) {
/* 253 */           project_rowWriter.setNullAt(5);
/* 254 */         } else {
/* 255 */           project_rowWriter.write(5, smj_value24);
/* 256 */         }
/* 257 */
/* 258 */         if (smj_isNull15) {
/* 259 */           project_rowWriter.setNullAt(6);
/* 260 */         } else {
/* 261 */           project_rowWriter.write(6, smj_value23);
/* 262 */         }
/* 263 */
/* 264 */         if (smj_isNull18) {
/* 265 */           project_rowWriter.setNullAt(7);
/* 266 */         } else {
/* 267 */           project_rowWriter.write(7, smj_value26);
/* 268 */         }
/* 269 */
/* 270 */         if (smj_isNull22) {
/* 271 */           project_rowWriter.setNullAt(8);
/* 272 */         } else {
/* 273 */           project_rowWriter.write(8, smj_value30);
/* 274 */         }
/* 275 */         project_result.setTotalSize(project_holder.totalSize());
/* 276 */         append(project_result.copy());
/* 277 */
/* 278 */       }
/* 279 */       if (shouldStop()) return;
/* 280 */     }
/* 281 */   }
/* 282 */ }
