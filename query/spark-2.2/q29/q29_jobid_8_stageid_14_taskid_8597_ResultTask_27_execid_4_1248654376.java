/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
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
/* 027 */     boolean isNull6 = i.isNullAt(2);
/* 028 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 029 */     boolean isNull5 = true;
/* 030 */     java.lang.String value5 = null;
/* 031 */     if (!isNull6) {
/* 032 */
/* 033 */       isNull5 = false;
/* 034 */       if (!isNull5) {
/* 035 */
/* 036 */         Object funcResult2 = null;
/* 037 */         funcResult2 = value6.toString();
/* 038 */         value5 = (java.lang.String) funcResult2;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull5) {
/* 043 */       values[2] = null;
/* 044 */     } else {
/* 045 */       values[2] = value5;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull8 = i.isNullAt(3);
/* 049 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 050 */     boolean isNull7 = true;
/* 051 */     java.lang.String value7 = null;
/* 052 */     if (!isNull8) {
/* 053 */
/* 054 */       isNull7 = false;
/* 055 */       if (!isNull7) {
/* 056 */
/* 057 */         Object funcResult3 = null;
/* 058 */         funcResult3 = value8.toString();
/* 059 */         value7 = (java.lang.String) funcResult3;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull7) {
/* 064 */       values[3] = null;
/* 065 */     } else {
/* 066 */       values[3] = value7;
/* 067 */     }
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */
/* 072 */   private void apply_0(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull2 = i.isNullAt(0);
/* 075 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 076 */     boolean isNull1 = true;
/* 077 */     java.lang.String value1 = null;
/* 078 */     if (!isNull2) {
/* 079 */
/* 080 */       isNull1 = false;
/* 081 */       if (!isNull1) {
/* 082 */
/* 083 */         Object funcResult = null;
/* 084 */         funcResult = value2.toString();
/* 085 */         value1 = (java.lang.String) funcResult;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull1) {
/* 090 */       values[0] = null;
/* 091 */     } else {
/* 092 */       values[0] = value1;
/* 093 */     }
/* 094 */
/* 095 */     boolean isNull4 = i.isNullAt(1);
/* 096 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 097 */     boolean isNull3 = true;
/* 098 */     java.lang.String value3 = null;
/* 099 */     if (!isNull4) {
/* 100 */
/* 101 */       isNull3 = false;
/* 102 */       if (!isNull3) {
/* 103 */
/* 104 */         Object funcResult1 = null;
/* 105 */         funcResult1 = value4.toString();
/* 106 */         value3 = (java.lang.String) funcResult1;
/* 107 */
/* 108 */       }
/* 109 */     }
/* 110 */     if (isNull3) {
/* 111 */       values[1] = null;
/* 112 */     } else {
/* 113 */       values[1] = value3;
/* 114 */     }
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */
/* 119 */   private void apply_2(InternalRow i) {
/* 120 */
/* 121 */     boolean isNull9 = i.isNullAt(4);
/* 122 */     long value9 = isNull9 ? -1L : (i.getLong(4));
/* 123 */     if (isNull9) {
/* 124 */       values[4] = null;
/* 125 */     } else {
/* 126 */       values[4] = value9;
/* 127 */     }
/* 128 */
/* 129 */     boolean isNull10 = i.isNullAt(5);
/* 130 */     long value10 = isNull10 ? -1L : (i.getLong(5));
/* 131 */     if (isNull10) {
/* 132 */       values[5] = null;
/* 133 */     } else {
/* 134 */       values[5] = value10;
/* 135 */     }
/* 136 */
/* 137 */     boolean isNull11 = i.isNullAt(6);
/* 138 */     long value11 = isNull11 ? -1L : (i.getLong(6));
/* 139 */     if (isNull11) {
/* 140 */       values[6] = null;
/* 141 */     } else {
/* 142 */       values[6] = value11;
/* 143 */     }
/* 144 */
/* 145 */   }
/* 146 */
/* 147 */
/* 148 */   public java.lang.Object apply(java.lang.Object _i) {
/* 149 */     InternalRow i = (InternalRow) _i;
/* 150 */
/* 151 */     values = new Object[7];
/* 152 */     apply_0(i);
/* 153 */     apply_1(i);
/* 154 */     apply_2(i);
/* 155 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 156 */     if (false) {
/* 157 */       mutableRow.setNullAt(0);
/* 158 */     } else {
/* 159 */
/* 160 */       mutableRow.update(0, value);
/* 161 */     }
/* 162 */
/* 163 */     return mutableRow;
/* 164 */   }
/* 165 */ }
