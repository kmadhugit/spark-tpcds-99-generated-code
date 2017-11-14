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
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private double smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 037 */   private UnsafeRow bhj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 040 */   private UnsafeRow project_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 043 */
/* 044 */   public GeneratedIterator(Object[] references) {
/* 045 */     this.references = references;
/* 046 */   }
/* 047 */
/* 048 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 049 */     partitionIndex = index;
/* 050 */     this.inputs = inputs;
/* 051 */     wholestagecodegen_init_0();
/* 052 */     wholestagecodegen_init_1();
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void wholestagecodegen_init_0() {
/* 057 */     smj_leftInput = inputs[0];
/* 058 */     smj_rightInput = inputs[1];
/* 059 */
/* 060 */     smj_rightRow = null;
/* 061 */
/* 062 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 063 */
/* 064 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 065 */     smj_result = new UnsafeRow(10);
/* 066 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 067 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 10);
/* 068 */     project_result = new UnsafeRow(8);
/* 069 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 070 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 071 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 072 */
/* 073 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 074 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private boolean findNextInnerJoinRows(
/* 079 */     scala.collection.Iterator leftIter,
/* 080 */     scala.collection.Iterator rightIter) {
/* 081 */     smj_leftRow = null;
/* 082 */     int comp = 0;
/* 083 */     while (smj_leftRow == null) {
/* 084 */       if (!leftIter.hasNext()) return false;
/* 085 */       smj_leftRow = (InternalRow) leftIter.next();
/* 086 */
/* 087 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 088 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 089 */       if (smj_isNull) {
/* 090 */         smj_leftRow = null;
/* 091 */         continue;
/* 092 */       }
/* 093 */       if (!smj_matches.isEmpty()) {
/* 094 */         comp = 0;
/* 095 */         if (comp == 0) {
/* 096 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 097 */         }
/* 098 */
/* 099 */         if (comp == 0) {
/* 100 */           return true;
/* 101 */         }
/* 102 */         smj_matches.clear();
/* 103 */       }
/* 104 */
/* 105 */       do {
/* 106 */         if (smj_rightRow == null) {
/* 107 */           if (!rightIter.hasNext()) {
/* 108 */             smj_value3 = smj_value;
/* 109 */             return !smj_matches.isEmpty();
/* 110 */           }
/* 111 */           smj_rightRow = (InternalRow) rightIter.next();
/* 112 */
/* 113 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 114 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 115 */           if (smj_isNull1) {
/* 116 */             smj_rightRow = null;
/* 117 */             continue;
/* 118 */           }
/* 119 */           smj_value2 = smj_value1;
/* 120 */         }
/* 121 */
/* 122 */         comp = 0;
/* 123 */         if (comp == 0) {
/* 124 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 125 */         }
/* 126 */
/* 127 */         if (comp > 0) {
/* 128 */           smj_rightRow = null;
/* 129 */         } else if (comp < 0) {
/* 130 */           if (!smj_matches.isEmpty()) {
/* 131 */             smj_value3 = smj_value;
/* 132 */             return true;
/* 133 */           }
/* 134 */           smj_leftRow = null;
/* 135 */         } else {
/* 136 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 137 */           smj_rightRow = null;;
/* 138 */         }
/* 139 */       } while (smj_leftRow != null);
/* 140 */     }
/* 141 */     return false; // unreachable
/* 142 */   }
/* 143 */
/* 144 */   private void wholestagecodegen_init_1() {
/* 145 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 146 */     bhj_result = new UnsafeRow(10);
/* 147 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 128);
/* 148 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 10);
/* 149 */     project_result1 = new UnsafeRow(8);
/* 150 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 151 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 8);
/* 152 */
/* 153 */   }
/* 154 */
/* 155 */   protected void processNext() throws java.io.IOException {
/* 156 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 157 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 158 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 159 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 160 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 161 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 162 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 163 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 164 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 165 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 166 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 167 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 168 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 169 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 170 */       while (smj_iterator.hasNext()) {
/* 171 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 172 */
/* 173 */         smj_numOutputRows.add(1);
/* 174 */
/* 175 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(1);
/* 176 */         int smj_value11 = smj_isNull9 ? -1 : (smj_rightRow1.getInt(1));
/* 177 */
/* 178 */         // generate join key for stream side
/* 179 */
/* 180 */         boolean bhj_isNull = smj_isNull9;
/* 181 */         long bhj_value = -1L;
/* 182 */         if (!smj_isNull9) {
/* 183 */           bhj_value = (long) smj_value11;
/* 184 */         }
/* 185 */         // find matches from HashedRelation
/* 186 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 187 */         if (bhj_matched == null) continue;
/* 188 */
/* 189 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 190 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 191 */
/* 192 */         boolean bhj_isNull5 = true;
/* 193 */         boolean bhj_value5 = false;
/* 194 */
/* 195 */         if (!bhj_isNull3) {
/* 196 */           if (!smj_isNull4) {
/* 197 */             bhj_isNull5 = false; // resultCode could change nullability.
/* 198 */             bhj_value5 = bhj_value3.equals(smj_value6);
/* 199 */
/* 200 */           }
/* 201 */
/* 202 */         }
/* 203 */         boolean bhj_isNull4 = bhj_isNull5;
/* 204 */         boolean bhj_value4 = false;
/* 205 */
/* 206 */         if (!bhj_isNull5) {
/* 207 */           bhj_value4 = !(bhj_value5);
/* 208 */         }
/* 209 */         if (bhj_isNull4 || !bhj_value4) continue;
/* 210 */
/* 211 */         bhj_numOutputRows.add(1);
/* 212 */
/* 213 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(3);
/* 214 */         UTF8String smj_value13 = smj_isNull11 ? null : (smj_rightRow1.getUTF8String(3));
/* 215 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(2);
/* 216 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(2));
/* 217 */         project_holder1.reset();
/* 218 */
/* 219 */         project_rowWriter1.zeroOutNullBytes();
/* 220 */
/* 221 */         if (smj_isNull11) {
/* 222 */           project_rowWriter1.setNullAt(0);
/* 223 */         } else {
/* 224 */           project_rowWriter1.write(0, smj_value13);
/* 225 */         }
/* 226 */
/* 227 */         if (smj_isNull10) {
/* 228 */           project_rowWriter1.setNullAt(1);
/* 229 */         } else {
/* 230 */           project_rowWriter1.write(1, smj_value12);
/* 231 */         }
/* 232 */
/* 233 */         if (bhj_isNull3) {
/* 234 */           project_rowWriter1.setNullAt(2);
/* 235 */         } else {
/* 236 */           project_rowWriter1.write(2, bhj_value3);
/* 237 */         }
/* 238 */
/* 239 */         if (smj_isNull4) {
/* 240 */           project_rowWriter1.setNullAt(3);
/* 241 */         } else {
/* 242 */           project_rowWriter1.write(3, smj_value6);
/* 243 */         }
/* 244 */
/* 245 */         if (smj_isNull2) {
/* 246 */           project_rowWriter1.setNullAt(4);
/* 247 */         } else {
/* 248 */           project_rowWriter1.write(4, smj_value4);
/* 249 */         }
/* 250 */
/* 251 */         if (smj_isNull5) {
/* 252 */           project_rowWriter1.setNullAt(5);
/* 253 */         } else {
/* 254 */           project_rowWriter1.write(5, smj_value7);
/* 255 */         }
/* 256 */
/* 257 */         if (smj_isNull7) {
/* 258 */           project_rowWriter1.setNullAt(6);
/* 259 */         } else {
/* 260 */           project_rowWriter1.write(6, smj_value9);
/* 261 */         }
/* 262 */
/* 263 */         if (smj_isNull6) {
/* 264 */           project_rowWriter1.setNullAt(7);
/* 265 */         } else {
/* 266 */           project_rowWriter1.write(7, smj_value8);
/* 267 */         }
/* 268 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 269 */         append(project_result1.copy());
/* 270 */
/* 271 */       }
/* 272 */       if (shouldStop()) return;
/* 273 */     }
/* 274 */   }
/* 275 */ }
