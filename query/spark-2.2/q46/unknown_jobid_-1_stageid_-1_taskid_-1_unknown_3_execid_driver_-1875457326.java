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
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 026 */   private UnsafeRow smj_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 033 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 035 */   private UnsafeRow bhj_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 038 */   private UnsafeRow project_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     wholestagecodegen_init_0();
/* 050 */     wholestagecodegen_init_1();
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void wholestagecodegen_init_0() {
/* 055 */     smj_leftInput = inputs[0];
/* 056 */     smj_rightInput = inputs[1];
/* 057 */
/* 058 */     smj_rightRow = null;
/* 059 */
/* 060 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 061 */
/* 062 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 063 */     smj_result = new UnsafeRow(9);
/* 064 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 065 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 066 */     project_result = new UnsafeRow(7);
/* 067 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 068 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 069 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 070 */
/* 071 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 072 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 073 */
/* 074 */   }
/* 075 */
/* 076 */   private boolean findNextInnerJoinRows(
/* 077 */     scala.collection.Iterator leftIter,
/* 078 */     scala.collection.Iterator rightIter) {
/* 079 */     smj_leftRow = null;
/* 080 */     int comp = 0;
/* 081 */     while (smj_leftRow == null) {
/* 082 */       if (!leftIter.hasNext()) return false;
/* 083 */       smj_leftRow = (InternalRow) leftIter.next();
/* 084 */
/* 085 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 086 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 087 */       if (smj_isNull) {
/* 088 */         smj_leftRow = null;
/* 089 */         continue;
/* 090 */       }
/* 091 */       if (!smj_matches.isEmpty()) {
/* 092 */         comp = 0;
/* 093 */         if (comp == 0) {
/* 094 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 095 */         }
/* 096 */
/* 097 */         if (comp == 0) {
/* 098 */           return true;
/* 099 */         }
/* 100 */         smj_matches.clear();
/* 101 */       }
/* 102 */
/* 103 */       do {
/* 104 */         if (smj_rightRow == null) {
/* 105 */           if (!rightIter.hasNext()) {
/* 106 */             smj_value3 = smj_value;
/* 107 */             return !smj_matches.isEmpty();
/* 108 */           }
/* 109 */           smj_rightRow = (InternalRow) rightIter.next();
/* 110 */
/* 111 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 112 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 113 */           if (smj_isNull1) {
/* 114 */             smj_rightRow = null;
/* 115 */             continue;
/* 116 */           }
/* 117 */           smj_value2 = smj_value1;
/* 118 */         }
/* 119 */
/* 120 */         comp = 0;
/* 121 */         if (comp == 0) {
/* 122 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 123 */         }
/* 124 */
/* 125 */         if (comp > 0) {
/* 126 */           smj_rightRow = null;
/* 127 */         } else if (comp < 0) {
/* 128 */           if (!smj_matches.isEmpty()) {
/* 129 */             smj_value3 = smj_value;
/* 130 */             return true;
/* 131 */           }
/* 132 */           smj_leftRow = null;
/* 133 */         } else {
/* 134 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 135 */           smj_rightRow = null;;
/* 136 */         }
/* 137 */       } while (smj_leftRow != null);
/* 138 */     }
/* 139 */     return false; // unreachable
/* 140 */   }
/* 141 */
/* 142 */   private void wholestagecodegen_init_1() {
/* 143 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 144 */     bhj_result = new UnsafeRow(9);
/* 145 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 128);
/* 146 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 147 */     project_result1 = new UnsafeRow(7);
/* 148 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 149 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 150 */
/* 151 */   }
/* 152 */
/* 153 */   protected void processNext() throws java.io.IOException {
/* 154 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 155 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 156 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 157 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 158 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 159 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 160 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 161 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 162 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 163 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 164 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 165 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 166 */       while (smj_iterator.hasNext()) {
/* 167 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 168 */
/* 169 */         smj_numOutputRows.add(1);
/* 170 */
/* 171 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 172 */         int smj_value10 = smj_isNull8 ? -1 : (smj_rightRow1.getInt(1));
/* 173 */
/* 174 */         // generate join key for stream side
/* 175 */
/* 176 */         boolean bhj_isNull = smj_isNull8;
/* 177 */         long bhj_value = -1L;
/* 178 */         if (!smj_isNull8) {
/* 179 */           bhj_value = (long) smj_value10;
/* 180 */         }
/* 181 */         // find matches from HashedRelation
/* 182 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 183 */         if (bhj_matched == null) continue;
/* 184 */
/* 185 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 186 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 187 */
/* 188 */         boolean bhj_isNull5 = true;
/* 189 */         boolean bhj_value5 = false;
/* 190 */
/* 191 */         if (!bhj_isNull3) {
/* 192 */           if (!smj_isNull4) {
/* 193 */             bhj_isNull5 = false; // resultCode could change nullability.
/* 194 */             bhj_value5 = bhj_value3.equals(smj_value6);
/* 195 */
/* 196 */           }
/* 197 */
/* 198 */         }
/* 199 */         boolean bhj_isNull4 = bhj_isNull5;
/* 200 */         boolean bhj_value4 = false;
/* 201 */
/* 202 */         if (!bhj_isNull5) {
/* 203 */           bhj_value4 = !(bhj_value5);
/* 204 */         }
/* 205 */         if (bhj_isNull4 || !bhj_value4) continue;
/* 206 */
/* 207 */         bhj_numOutputRows.add(1);
/* 208 */
/* 209 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(3);
/* 210 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(3));
/* 211 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(2);
/* 212 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(2));
/* 213 */         project_holder1.reset();
/* 214 */
/* 215 */         project_rowWriter1.zeroOutNullBytes();
/* 216 */
/* 217 */         if (smj_isNull10) {
/* 218 */           project_rowWriter1.setNullAt(0);
/* 219 */         } else {
/* 220 */           project_rowWriter1.write(0, smj_value12);
/* 221 */         }
/* 222 */
/* 223 */         if (smj_isNull9) {
/* 224 */           project_rowWriter1.setNullAt(1);
/* 225 */         } else {
/* 226 */           project_rowWriter1.write(1, smj_value11);
/* 227 */         }
/* 228 */
/* 229 */         if (bhj_isNull3) {
/* 230 */           project_rowWriter1.setNullAt(2);
/* 231 */         } else {
/* 232 */           project_rowWriter1.write(2, bhj_value3);
/* 233 */         }
/* 234 */
/* 235 */         if (smj_isNull4) {
/* 236 */           project_rowWriter1.setNullAt(3);
/* 237 */         } else {
/* 238 */           project_rowWriter1.write(3, smj_value6);
/* 239 */         }
/* 240 */
/* 241 */         if (smj_isNull2) {
/* 242 */           project_rowWriter1.setNullAt(4);
/* 243 */         } else {
/* 244 */           project_rowWriter1.write(4, smj_value4);
/* 245 */         }
/* 246 */
/* 247 */         if (smj_isNull5) {
/* 248 */           project_rowWriter1.setNullAt(5);
/* 249 */         } else {
/* 250 */           project_rowWriter1.write(5, smj_value7);
/* 251 */         }
/* 252 */
/* 253 */         if (smj_isNull6) {
/* 254 */           project_rowWriter1.setNullAt(6);
/* 255 */         } else {
/* 256 */           project_rowWriter1.write(6, smj_value8);
/* 257 */         }
/* 258 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 259 */         append(project_result1.copy());
/* 260 */
/* 261 */       }
/* 262 */       if (shouldStop()) return;
/* 263 */     }
/* 264 */   }
/* 265 */ }
